package uta.cse3310;

public class User {
    private String nickname;
    private int hiScore;
    private int currentPoints;

    public User() {
        // Constructor logic here
        this.nickname = "Guest"; // default nick
        this.hiScore = 0;
        this.currentPoints = 0;
    }

    public void pickWord(WordBank bank) {
        // currentWord = bank.chooseWord();
        // if (currentWord != null) {
        //     System.out.println(nickname + " has picked the word: " + currentWord);
        // } else {
        //     System.out.println("No words available to pick.");
        // }
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
