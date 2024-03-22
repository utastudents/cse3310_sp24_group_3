package uta.cse3310;

import java.util.Timer;
import java.util.TimerTask;

public class GameState {
    private int gameNumber;
    private int numPlayers;
    private User[] users; 


    public GameState(int gameNumber, int numPlayers, User[] users) {
        this.gameNumber = gameNumber;
        this.numPlayers = numPlayers;
        this.users = users;

    }
    public void endGame() {
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }




}
