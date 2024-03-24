package uta.cse3310;

import java.util.Timer;
import java.util.TimerTask;

public class GameState {
    public User users;
    public int gameNumber;
    public int numPlayers;
    public int shotClock;
    public int timer;
    public String[] Msg;
    public User
    private User[] users; 

    GameState() {
        this.gameNumber = gameNumber;
        this.numPlayers = numPlayers;
        this.users = users;
        Msg = new String[4];        
        Msg[0] = "";
              
    }
    public void StartGame() {

    }
    public String[] calculateWinner(){

    }

    private boolean checkWinnerWord(List<String>, User users) {

    }

    private boolean CheckHorizontal(User users) {
       
    }

    private boolean CheckVertical(User users) {
        
    }

    private boolean CheckBoard(User users) {
        
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
