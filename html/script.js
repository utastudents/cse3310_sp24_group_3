// Display for the boards 
const joinButton = document.getElementById('join-button');
const gameLobby = document.getElementById('game-lobby');
const gameUI = document.querySelector('.game-container');

gameUI.style.display = 'none';
joinButton.addEventListener('click', function() {
        // Hide the game lobby
    gameLobby.style.display = 'none';
        // Show the game UI
    gameUI.style.display = 'block';
});

//Lobby UI Creation
// document.getElementById("bottomMessage").innerHTML = obj.Msg[idx]; //finish in morning 

//Game UI Creation
window.addEventListener('DOMContentLoaded', (event) => {
    const grid = document.getElementById('grid');
    const wordList = document.getElementById('word-list');
  
    // Insert grid cells 
    //fix the grid for proper functionality 
    const gridSize = 10; // to create a 10x10 grid
    for (let i = 0; i < gridSize * gridSize; i++) {
      const cell = document.createElement('div');
      cell.className = 'grid-cell';
      grid.appendChild(cell);
    }
  
    // Insert word list 
    const words = [
    ];
  
    words.forEach(word => {
      const li = document.createElement('li');
      li.textContent = word;
      wordList.appendChild(li);
    });
  });

 