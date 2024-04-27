package uta.cse3310;
import java.util.List;


public class Game {
    private char[][] letterGrid;
    private WordGrid grid;
    private int[][] answerGrid;
    private WordGrid answer;
    public String[] Msg;
    public PlayerType[] Button;
    public PlayerType Players;
    public Stats gameStats; 
    public User user; 
    // private int numPlayers;
    // private int timer;
    private String message;
    private List<User> userList;
    public int GameId;
    private String[] validWords;


    // Constructors
    Game(Stats stats) {
        
    }
    // Start the game, ensuring minimum players are present
    public void StartGame() {
        
    }

    public void gridCreation() {
        letterGrid = grid.createGrid(); 
        answerGrid = answer.createAnswer();  
    }

    public void Update(UserEvent U) {
        System.out.println("The user event is " + U.PlayerIdx + "  " + U.Button);
    }

    /*      Methods not needed because they are replaced with checkWinnerWord()

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
    */

    // End the game and calculate results
    public int endGame() {
        message = "Game Over";
        return calculateScore();
    }
    // public List<String> validWords(){
    //     for(User user : user.nickList)
    //     {

    //     }
    //     return validWords;
    // }

    // Method that checks if the user input matches a word in the answer grid.
    // Takes 2 end coordinates that the user selects.
    // If the index at both coordinates match in the answer grid, the word selected was right
    // and hte function returns true, false of not.
    public boolean checkWinnerWord(int row1, int col1, int row2, int col2) {
        if ((answerGrid[row1][col1] != 0) && (answerGrid[row2][col2] != 0))
            return true;
        else
            return false;
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
