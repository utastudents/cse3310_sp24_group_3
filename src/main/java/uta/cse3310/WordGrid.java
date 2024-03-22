package uta.cse3310;

public class WordGrid {
    private int density;
    private char[][] grid;

    public WordGrid(int density) {
        this.density = density;
    }

    public char[][] make_grid(String[] wordlist) {

        return new char[density][density];
    }
}
