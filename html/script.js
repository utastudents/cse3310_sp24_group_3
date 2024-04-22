const joinButton = document.getElementById('join-button');
const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');
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

joinButton.addEventListener('click', function() {
  const nickname = nicknameInput.value;
  if (nickname) {
      const data = { type: 'join', nickname: nickname };
      connection.send(JSON.stringify(data));
  } else {
      alert("Please enter a nickname");
  }
});







