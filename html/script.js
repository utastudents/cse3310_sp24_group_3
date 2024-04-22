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

joinButton.addEventListener('click', function() {
  const nickname = nicknameInput.value;
  if (!nickname) {
      alert('Please enter a nickname.');
      return;
  }
  
  // Hide the game lobby and show the game UI as before
  gameLobby.style.display = 'none';
  gameUI.style.display = 'block';

  // Setup message sending
  sendMessageButton.addEventListener('click', function() {
      const message = chatMessage.value;
      if (!message) {
          alert('Please type a message.');
          return;
      }
      const data = { nickname: nickname, message: message };
      connection.send(JSON.stringify(data));
      chatMessage.value = ''; // Clear the message input after sending
  });

  // Handle incoming messages
  connection.onmessage = function(event) {
      const incomingData = JSON.parse(event.data);
      const displayMessage = document.createElement('div');
      displayMessage.textContent = incomingData.nickname + ": " + incomingData.message;
      messageDisplay.appendChild(displayMessage);
  };
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



