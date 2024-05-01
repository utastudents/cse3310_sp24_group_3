const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');
const nicknameInput = document.getElementById('nickname');
const joinButton = document.getElementById('join-button');
const twoPlayerGameButton = document.getElementById('2player-game');
const fourPlayerGameButton = document.getElementById('4player-game');
const sendMessageButton = document.getElementById('send-message');
const chatMessageInput = document.getElementById('chat-message');
const nicknameList = document.getElementById('nickname-list'); // New reference to the nickname list

// Create a connection to the server using WebSocket
var connection = null;

// Establish WebSocket connection
var serverUrl = "ws://" + window.location.hostname + ":9103";
connection = new WebSocket(serverUrl);

connection.onopen = function (evt) {
  console.log("Connection opened.");
  // Optionally request the current list of nicknames
  connection.send(JSON.stringify({ action: "requestCurrentPlayers" }));
};


connection.onclose = function (evt) {
  console.log("close");
  if (document.getElementById("topMessage")) {
    document.getElementById("topMessage").innerHTML = "Server Offline";
  }
};

connection.onmessage = function (evt) {
  var msg = evt.data;
  console.log("Message received: " + msg);
  const obj = JSON.parse(msg);

  if (obj.type === "currentPlayers") {
      // Received the list of all current players
      updateLeaderboard(obj.nicknames);
  } else if (obj.type === "newPlayer") {
      // Add new player to the list
      const listItem = document.createElement('li');
      listItem.textContent = obj.nickname;
      nicknameList.appendChild(listItem);
  } else if ('words' in obj) {
      var words = obj.wordBank;
      displayWordList(words); // Update the leaderboard with the new list
  }
};

gameUI.style.display = 'none'; // Hide game UI initially

// Event Listeners for buttons
joinButton.onclick = function() {
  if (nicknameInput.value) {
    console.log("Nickname:", nicknameInput.value);
    // Potentially send nickname to the server
    connection.send(JSON.stringify({ action: "join", nickname: nicknameInput.value }));

    // Add nickname to the lobby list directly
    const listItem = document.createElement('li');
    listItem.textContent = nicknameInput.value;
    nicknameList.appendChild(listItem);

    // Clear the input field after adding the nickname to the list
    nicknameInput.value = "";
  } else {
    alert("Please enter a nickname.");
  }
};

twoPlayerGameButton.onclick = function() {
  console.log("Requesting 2-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 2 }));
  twoPlayer(); // Trigger the two-player game setup
};

fourPlayerGameButton.onclick = function() {
  console.log("Requesting 4-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 4 }));
  fourPlayer(); // Trigger the four-player game setup
};

sendMessageButton.onclick = function() {
  if (chatMessageInput.value) {
    console.log("Sending message:", chatMessageInput.value);
    // Send message to server
    connection.send(JSON.stringify({ action: "sendMessage", message: chatMessageInput.value }));
    chatMessageInput.value = ""; // Clear the input after sending
  }
};

function createGrid(playerType) {
  var rows = playerType === 'twoPlayer' ? 15 : 25;
  var columns = playerType === 'twoPlayer' ? 15 : 25;
  const gridElement = document.getElementById('grid');
  gridElement.innerHTML = ''; // Clear existing grid first
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      const cellButton = document.createElement('button');
      const randomChar = String.fromCharCode('A'.charCodeAt(0) + Math.floor(Math.random() * 26));
      cellButton.textContent = randomChar;
      gridElement.appendChild(cellButton);
    }
  }
}

function updateLeaderboard(nicknames) {
  nicknameList.innerHTML = ""; // Clear existing nicknames
  nicknames.forEach(function(nickname) {
      var listItem = document.createElement('li');
      listItem.textContent = nickname;
      nicknameList.appendChild(listItem);
  });
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
  console.log("Two-player game started.");
}

function fourPlayer() {
  gameLobby.style.display = 'none';
  gameUI.style.display = 'block';
  createGrid('fourPlayer');
  console.log("Four-player game started.");
}
