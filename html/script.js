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
  gridContainer.innerHTML = '';

  const buttonTable = document.createElement('table');
  var number = 1; 
  let rows = 25;
  let columns = 25;
  for (let i = 0; i < rows; i++) {
    const row = buttonTable.insertRow();

    for (let j = 0; j < columns; j++) {
      const cell = row.insertCell();
      const button = document.createElement('button');
      
      button.textContent = ''; 
      button.id = 'button' + number; 

      cell.appendChild(button);

      number++;
    }
  }
  gridContainer.appendChild(buttonTable);
}



function buttonclick(i) {
  U = new UserEvent();
  U.Button = i;
  if (idx == 0)
      U.PlayerIdx = "XPLAYER";
  else
      U.PlayerIdx = "OPLAYER";
  U.GameId = gameid;
  connection.send(JSON.stringify(U));
  console.log(JSON.stringify(U))
}

