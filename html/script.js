const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');
const nicknameInput = document.getElementById('nickname');

// Create a connection to the server using WebSocket

var connection = null;

// Establish WebSocket connection
var serverUrl = "ws://" + window.location.hostname + ":9880";
connection = new WebSocket(serverUrl);

connection.onopen = function (evt) {
  console.log("open");
}
connection.onclose = function (evt) {
  console.log("close");
  document.getElementById("bottomMessage").innerHTML = "Server Offline"
}

gameUI.style.display = 'none';



function twoPlayer()
{

}

function fourPlayer()
{

}

function playersPlaying()
{

}

function sendMessage()
{

}

function makeGrid()
{

}