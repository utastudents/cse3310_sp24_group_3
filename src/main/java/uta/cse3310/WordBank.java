
package uta.cse3310;

import java.util.Random;

public class WordBank {
    private String[] wordlist;
    private char[][] grid;
    private int density;
    private static final String[] ALL_WORDS = {/* all possible words */};
    public char[][] make_grid(String[] wordlist) {

        return new char[density][density];
    }

    public void setDensity(int density) {
        this.density = density;
    }
    public static String[] generateRandomWords(int numWords) {
        Random random = new Random();
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            int randomIndex = random.nextInt(ALL_WORDS.length);
            words[i] = ALL_WORDS[randomIndex];
        }
        return words; // return an array of random words
    }
    /*...*/
    public String[] chooseWords(String[] wordlist) {
        this.wordlist = wordlist;
        return wordlist;
    }    

}