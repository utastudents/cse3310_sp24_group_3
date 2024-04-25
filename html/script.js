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

gameUI.style.display = 'none'; // Hide game UI initially

// Event Listeners for buttons
joinButton.onclick = function() {
  if (nicknameInput.value) {
    console.log("Nickname:", nicknameInput.value);
    // Potentially send nickname to the server
    connection.send(JSON.stringify({ action: "join", nickname: nicknameInput.value }));
    gameLobby.style.display = 'none'; // Hide the lobby
    gameUI.style.display = ''; // Show game UI
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

// Additional functions related to gameplay might be added here
function makeGrid() {
  // Placeholder function to make game grid
  console.log("Making game grid...");
}
