const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');
const nicknameInput = document.getElementById('nickname');
const joinButton = document.getElementById('join-button');
const twoPlayerGameButton = document.getElementById('2player-game');
const fourPlayerGameButton = document.getElementById('4player-game');
const sendMessageButton = document.getElementById('send-message');
const chatMessageInput = document.getElementById('chat-message');


// Create a connection to the server using WebSocket
var connection = null;

// Establish WebSocket connection
//9880
//9103
var serverUrl = "ws://" + window.location.hostname + ":9103";
connection = new WebSocket(serverUrl);

connection.onopen = function (evt) {
  console.log("open");
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

  // Handle different types of messages
  if ('nicknameList' in obj) {
    var name = obj.User;
    document.getElementById("leaderboard").innerHTML = name.nickname;
  }

  if ('words' in obj) {
    var words = obj.wordBank;
    displayWordList(words); // Update the leaderboard with the new list
  }
}

gameUI.style.display = 'none'; // Hide game UI initially

// Event Listeners for buttons
joinButton.onclick = function() {
  if (nicknameInput.value) {
    console.log("Nickname:", nicknameInput.value);
    // Potentially send nickname to the server
    connection.send(JSON.stringify({ action: "join", nickname: nicknameInput.value }));
    nicknameInput.value = "";
  } else {
    alert("Please enter a nickname.");
  }
};

twoPlayerGameButton.onclick = function() {
  console.log("Requesting 2-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 2 }));
};

fourPlayerGameButton.onclick = function() {
  console.log("Requesting 4-player game...");
  connection.send(JSON.stringify({ action: "startGame", players: 4 }));
};

sendMessageButton.onclick = function() {
  if (chatMessageInput.value) {
    console.log("Sending message:", chatMessageInput.value);
    // Send message to server
    connection.send(JSON.stringify({ action: "sendMessage", message: chatMessageInput.value }));
    chatMessageInput.value = ""; // Clear the input after sending
  }
};

function createGrid() {
  var rows = 25;
  var columns = 25;
  const gridElement = document.getElementById('grid');
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
  var leaderboardElement = document.getElementById("leaderboard");
  leaderboardElement.innerHTML = "";
  nicknames.forEach(function(nickname) {
    var listItem = document.createElement("div");
    listItem.textContent = nickname;
    leaderboardElement.appendChild(listItem);
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
function twoPLayer()
{
  gameLobby.style.display = 'none'; // Hide the lobby
  gameUI.style.display = ''; // Show game 
  createGrid();

}
function fourPlayer()
{
  gameLobby.style.display = 'none'; // Hide the lobby
  gameUI.style.display = ''; // Show game 
  createGrid();
}
function wordBank()
{

}

//fix
// function buttonclick(i) {
//   U = new UserEvent();
//   U.Button = i;
//   if (idx == 0)
//       U.PlayerIdx = "XPLAYER";
//   else
//       U.PlayerIdx = "OPLAYER";
//   U.GameId = gameid;
//   connection.send(JSON.stringify(U));
//   console.log(JSON.stringify(U))
// }





