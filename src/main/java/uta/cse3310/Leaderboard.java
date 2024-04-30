package uta.cse3310;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {

    private User[] users;

    public Leaderboard(User[] users) {
        this.users = users;
        sortUsersByScore();
    }

    private void sortUsersByScore() {
        Arrays.sort(this.users, Comparator.comparingInt(User::getScore).reversed());
    }

    public User[] getUsers() {
        return this.users;
    }

    public String displayLeaderboard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Leaderboard:\n");
        for (int i = 0; i < users.length; i++) {
            sb.append(i + 1).append(". ").append(users[i].getName())
              .append(" - Score: ").append(users[i].getScore()).append("\n");
        }
        return sb.toString();
    }

    public int leaderboardEntries() {
        return users.length;
    }
}

class User {
    private String name;
    private int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
