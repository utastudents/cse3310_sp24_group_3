const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');
const nicknameInput = document.getElementById('nickname');
const joinButton = document.getElementById('join-button');
const twoPlayerGameButton = document.getElementById('2player-game');
const fourPlayerGameButton = document.getElementById('4player-game');
const sendMessageButton = document.getElementById('send-message');
const chatMessageInput = document.getElementById('chat-message');
const nicknameList = document.getElementById('nickname-list');

// Create a connection to the server using WebSocket
var connection = null;
var serverUrl = "ws://" + window.location.hostname + ":9103";
connection = new WebSocket(serverUrl);

connection.onopen = function (evt) {
  console.log("Connection opened.");
  connection.send(JSON.stringify({ action: "requestCurrentPlayers" })); // Request current players upon opening the connection
};

connection.onclose = function (evt) {
  console.log("Connection closed.");
  if (document.getElementById("topMessage")) {
    document.getElementById("topMessage").innerHTML = "Server Offline";
  }
};

connection.onmessage = function (evt) {
  var msg = evt.data;
  console.log("Message received: " + msg);
  const obj = JSON.parse(msg);

  if (obj.type === "currentPlayers") {
    updateLeaderboard(obj.nicknames); // Handle the list of all current players
  } else if (obj.type === "newPlayer") {
    addNicknameToList(obj.nickname); // Add new player to the list
  } else if ('words' in obj) {
    displayWordList(obj.wordBank); // Update the word list
  }
};

// Event Listeners for buttons
joinButton.onclick = function() {
  if (nicknameInput.value) {
    console.log("Nickname:", nicknameInput.value);
    connection.send(JSON.stringify({ action: "join", nickname: nicknameInput.value }));
    // Do not add here; wait for the server to confirm and broadcast
    nicknameInput.value = "";
  } else {
    alert("Please enter a nickname.");
  }
};

twoPlayerGameButton.onclick = function() {
  console.log("Requesting 2-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 2 }));
  twoPlayer();
};

fourPlayerGameButton.onclick = function() {
  console.log("Requesting 4-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 4 }));
  fourPlayer();
};

sendMessageButton.onclick = function() {
  if (chatMessageInput.value) {
    connection.send(JSON.stringify({ action: "sendMessage", message: chatMessageInput.value }));
    chatMessageInput.value = "";
  }
};

function addNicknameToList(nickname) {
  const listItem = document.createElement('li');
  listItem.textContent = nickname;
  nicknameList.appendChild(listItem);
}

function updateLeaderboard(nicknames) {
  nicknameList.innerHTML = ""; // Clear existing nicknames
  nicknames.forEach(addNicknameToList);
}

function displayWordList(words) {
  const wordListElement = document.getElementById('word-list');
  wordListElement.innerHTML = "";
  words.forEach(function(word) {
    const listItem = document.createElement('li');
    listItem.textContent = word;
    wordListElement.appendChild(listItem);
  });
}

function twoPlayer() {
  gameLobby.style.display = 'none';
  gameUI.style.display = 'block';
  createGrid('twoPlayer');
}

function fourPlayer() {
  gameLobby.style.display = 'none';
  gameUI.style.display = 'block';
  createGrid('fourPlayer');
}
