package uta.cse3310;

import java.util.*;
public class User {
    String nickname;
    int score;
    int id;
    ArrayList<User> nickList;

    public User(ArrayList<User> nickList, String nickname){
        setNickname(nickList, nickname);
        if(!userVerfiy(nickList, nickname)){
            this.nickname = null;
        }
    }

    public boolean userVerfiy(ArrayList<User> nickList, String nickname){
       for(User user : nickList){
        if(user.getNickname() == nickname){
            return false;
        }
       }
        return true; 
    }
    public User(String nickname) {
        this.nickname = nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(ArrayList<User> nickList, String nickname) {
        if(userVerfiy(nickList, nickname)){
            this.nickname = nickname;  
            this.id = nickList.size()+1; 
        }
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
