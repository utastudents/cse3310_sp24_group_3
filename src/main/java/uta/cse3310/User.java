package uta.cse3310;

public class User {
    private String nickname;
    private int hiScore;
    private int currentPoints;

    public String[] User() {
        // Constructor logic here
    }

    public void pickWord() {
    }


    public int joinGame() {
        
        return 0; 
    }

    public int getScore() {
    
        return currentPoints; 
    }

    // Getters and setters for nickname, hiScore, and currentPoints
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHiScore() {
        return hiScore;
    }

    public void setHiScore(int hiScore) {
        this.hiScore = hiScore;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
}
