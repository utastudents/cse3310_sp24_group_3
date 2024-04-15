package uta.cse3310;

import java.util.List;

public class GameSession {
    private char[][] letterGrid;
    private List<String> validWords;
    private int numPlayers;
    private int timer;
    private int shotClock;
    private String message;
    private List<User> userList;

    // Constructors
    public GameSession(int rows, int columns, int numPlayers, int timer, int shotClock, List<User> userList, List<String> validWords) {
        this.letterGrid = new char[rows][columns];
        initializeGrid();
        this.validWords = validWords;
        this.numPlayers = numPlayers;
        this.timer = timer;
        this.shotClock = shotClock;
        this.userList = userList;
        this.message = ""; // default message initialization
    }

    // Initialize the grid with a default character
    private void initializeGrid() {
        for (int i = 0; i < letterGrid.length; i++) {
            for (int j = 0; j < letterGrid[i].length; j++) {
                letterGrid[i][j] = '-';
            }
        }
    }

    // Start the game, ensuring minimum players are present
    public void startGame() {
        if (numPlayers >= 2) {
            message = "Game Started";
            // Additional logic to start timers, etc.
        } else {
            message = "Waiting for other players to join";
        }
    }

    // End the game and calculate results
    public int endGame() {
        message = "Game Over";
        return calculateScore();
    }

    // Placeholder methods for word checking
    public boolean checkWinnerWord(String word) {
        // This could be expanded to check if the word is correctly placed and valid
        return validWords.contains(word);
    }

    // Determine the winner based on scores
    public String calculateWinner() {
        User winner = null;
        int maxScore = 0;
        for (User user : userList) {
            if (user.getScore() > maxScore) {
                maxScore = user.getScore();
                winner = user;
            }
        }
        return (winner != null && winner.getScore() > 0) ? winner.getNickname() : "No Winner";
    }

    // Calculate the total score of all players
    public int calculateScore() {
        int totalScore = 0;
        for (User user : userList) {
            totalScore += user.getScore();
        }
        return totalScore;
    }

    // Getters and Setters
    public char[][] getLetterGrid() {
        return letterGrid;
    }

    public void setLetterGrid(char[][] letterGrid) {
        this.letterGrid = letterGrid;
    }

    public List<String> getValidWords() {
        return validWords;
    }

    public void setValidWords(List<String> validWords) {
        this.validWords = validWords;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getShotClock() {
        return shotClock;
    }

    public void setShotClock(int shotClock) {
        this.shotClock = shotClock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
