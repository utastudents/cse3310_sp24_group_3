package uta.cse3310;

public class WordBank {
    private String[] wordlist;
    private char[][] grid;
    private int density;

    public char[][] make_grid(String[] wordlist) {

        return new char[density][density];
    }


    public String[] chooseWords(String[] wordlist) {
        this.wordlist = wordlist;
        return wordlist;
    }    

}