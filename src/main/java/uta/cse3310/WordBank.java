package uta.cse3310;

import java.util.Random;

public class WordBank {
    private String[] wordlist;
    private char[][] grid;
    private int density; // This should be a measure of how densely the grid is filled with words

    public WordBank(String[] wordlist, int density) {
        this.wordlist = wordlist;
        this.density = density;
        this.grid = makeGrid();
    }

    // Generates a word grid based on the density and available words
    private char[][] makeGrid() {
        int size = calculateGridSize();
        grid = new char[size][size];
        fillGridWithBlanks(grid);
        placeWordsInGrid(grid);
        return grid;
    }

    // Calculates appropriate grid size based on density and wordlist
    private int calculateGridSize() {

        return density;
    }

    // Fills the grid with placeholder characters (e.g., '.')
    private void fillGridWithBlanks(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '.';
            }
        }
    }

    // Randomly places words from the wordlist into the grid
    private void placeWordsInGrid(char[][] grid) {
        Random random = new Random();
        // This is a very basic placement that doesn't check for overlaps or correct orientation
        for (String word : wordlist) {
            int x = random.nextInt(grid.length - word.length());
            int y = random.nextInt(grid.length);
            for (int i = 0; i < word.length(); i++) {
                grid[y][x + i] = word.charAt(i); // Horizontal placement
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public String[] getWordlist() {
        return wordlist;
    }

    public void setWordlist(String[] wordlist) {
        this.wordlist = wordlist;
        this.grid = makeGrid(); // Remake the grid whenever the word list changes
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
        this.grid = makeGrid(); // Remake the grid whenever the density changes
    }
}