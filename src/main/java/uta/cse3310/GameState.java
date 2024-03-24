package uta.cse3310;
import java.util.List;


public class GameState {

    private int numPlayers;
    private int timer;
    private int shotClock;
    private String message;

    // Constructors
    public GameState(int numPlayers, int timer, int shotClock) {
        this.numPlayers = numPlayers;
        this.timer = timer;
        this.shotClock = shotClock;
        this.message = ""; // default message initialization
    }

    // Methods
    public int getUserList(List<User> userList) {

        return userList.size();
    }

    public void startGame() {

    }

    public int endGame() {

        return 0;
    }

    public boolean checkWinnerWord() {

        return false;
    }

    public boolean checkVertical() {

        return false;
    }

    public boolean checkHorizontal() {

        return false;
    }

    public String calculateWinner() {

        return "";
    }


    public int timer() {
        return 0;
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