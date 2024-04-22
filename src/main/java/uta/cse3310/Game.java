package uta.cse3310;
import java.util.List;


public class Game {
    private char[][] letterGrid;
    public PlayerType[] Button;
    public PlayerType Players;
    public Stats gameStats; 
    private User user; 
    private int numPlayers;
    private int timer;
    private String message;
    private List<User> userList;
    public int GameId;
    private List<String> validWords;
    // Constructors
    Game(Stats stats) {
        
    }
    // Start the game, ensuring minimum players are present
    public void StartGame() {
        if (numPlayers >= 2) {
            message = "Game Started";
            // Additional logic to start timers, etc.
        } else {
            message = "Waiting for other players to join";
        }
    }

    public void Update(UserEvent U) {
        System.out.println("The user event is " + U.PlayerIdx + "  " + U.Button);
    }

    private boolean CheckLine(int i, int j, int k, PlayerType player) {
        return player == Button[i] && player == Button[j] && player == Button[k];
    }

    private boolean CheckHorizontal(PlayerType player) {
        return CheckLine(0, 1, 2, player) | CheckLine(3, 4, 5, player) | CheckLine(6, 7, 8, player);
    }

    private boolean CheckVertical(PlayerType player) {
        return CheckLine(0, 3, 6, player) | CheckLine(1, 4, 7, player) | CheckLine(2, 5, 8, player);
    }

    private boolean CheckDiagonal(PlayerType player) {
        return CheckLine(0, 4, 8, player) | CheckLine(2, 4, 6, player);
    }

    private boolean CheckBoard(PlayerType player) {
        return CheckHorizontal(player) | CheckVertical(player) | CheckDiagonal(player);
    }

    // End the game and calculate results
    public int endGame() {
        message = "Game Over";
        return calculateScore();
    }
    public List<String> validWords(){
        for(User user : user.nickList)
        {

        }
        return validWords;
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

    public String message() {
        return message;
    }

    public void clock(){

    }

}
