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
        // Hide the game lobby
    gameLobby.style.display = 'none';
        // Show the game UI
    gameUI.style.display = 'block';
});

function createGrid() {
  const gridContainer = document.getElementById('grid');
  gridContainer.innerHTML = ''; // Clear existing grid if any
  let number = 1; // Button identifier

  for (let i = 0; i < 50; i++) {
      for (let j = 0; j < 50; j++) {
          const button = document.createElement('button');
          button.id = 'button' + number;
          button.textContent = ''; 
          button.style.width = '20px'; 
          button.style.height = '20px'; 
          button.addEventListener('click', () => buttonClick(number));
          gridContainer.appendChild(button);
          number++;
      }
  }
}


function buttonClick(buttonId) {
  const button = document.getElementById('button' + buttonId);
  const U = { Button: buttonId, PlayerIdx: 'SomePlayer', GameId: 'SomeGameId' }; 
  connection.send(JSON.stringify(U));
  console.log('Sent:', JSON.stringify(U));

  button.style.backgroundColor = 'red'; 
}

