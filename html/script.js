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

//Game UI creation
window.addEventListener('DOMContentLoaded', (event) => {
    const scoreboard = document.getElementById('scoreboard');
    const grid = document.getElementById('grid');
    const wordList = document.getElementById('word-list');
  
    const scores = [
      { user: 'User 1', score: 0 },
      { user: 'User 2', score: 0 },
      { user: 'User 3', score: 0 },
      { user: 'User 4', score: 0 }
    ];
  
    scores.forEach(score => {
      const div = document.createElement('div');
      div.className = 'score';
      div.textContent = `${score.user}: ${score.score}`;
      scoreboard.appendChild(div);
    });
  
    // Insert grid cells
    const gridSize = 10; // to create a 10x10 grid
    for (let i = 0; i < gridSize * gridSize; i++) {
      const cell = document.createElement('div');
      cell.className = 'grid-cell';
      grid.appendChild(cell);
    }
  
    // Insert word list 
    const words = [
      'Word 1', 'Word 2', 'Word 3', 'Word 4', 'Word 5',
      'Word 6', 'Word 7', 'Word 8', 'Word 9', 'Word 10',
      'Word 11', 'Word 12'
    ];
  
    words.forEach(word => {
      const li = document.createElement('li');
      li.textContent = word;
      wordList.appendChild(li);
    });
  });

function fetchPlayerScores() {
    // Simulate fetching data from server
    const scores = [1200, 950, 1100, 890]; // Example scores
    document.getElementById('user1-max-score').textContent = scores[0];
    document.getElementById('user2-max-score').textContent = scores[1];
    document.getElementById('user3-max-score').textContent = scores[2];
    document.getElementById('user4-max-score').textContent = scores[3];
}

function fetchConcurrentGames() {
    const concurrentGames = 5; // Example number of concurrent games
    document.getElementById('concurrent-games-number').textContent = concurrentGames;
}
