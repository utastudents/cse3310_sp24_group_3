package uta.cse3310;

import java.util.List;

public class GameState {

    private int numPlayers;
    private int timer;
    private int shotClock;
    private String message;
    private List<User> userList;

    // Constructors
    public GameState(int numPlayers, int timer, int shotClock, List<User> userList) {
        this.numPlayers = numPlayers;
        this.timer = timer;
        this.shotClock = shotClock;
        this.message = ""; // default message initialization
        this.userList = userList;
    }

    // Methods
    public int getUserList(List<User> userList) {

        return userList.size();
    }

    public void startGame() {
        if (numPlayers >= 2) {
            message = "Game Started";
        } else {
            message = "Waiting for other player to join";
        }
    }

    public int endGame() {
        message = "Game Over";
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

        User winner = new User();
        int maxScore = 0;
        for (User user : userList) {
            if (user.getScore() > maxScore) {
                maxScore = user.getScore();
                winner = user;
            }
        }
        if (winner.getScore() > 0){
            return winner.getNickname();
        }
        else {
            return "No Winner";
        }
    }

    public int calculateScore() {
        int score = 0;
        for (User user : userList) {
            score += user.getScore();
        }
        return score;
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