package uta.cse3310;
import java.util.Random;

public class WordGrid {
    public WordBank bank;
    public String[] words;
    public User user;
    public int rows = 25;
    public int columns = 25;
    private int numWords = 15;

    public String[] wordsCreated(){ 
        String filePath = "words.txt";

        words = WordBank.generateRandomWords(numWords, filePath);

        return words;
    }
    
    public char[][] createGrid() {
        char[][] grid = new char[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char randomChar = (char) ('A' + random.nextInt(26));
                grid[i][j] = randomChar;  
            }
        }
        return grid;
    }

    public int[][] createAnswer() {
        int[][] answer = new int[rows][columns];
        return answer;
    }


    // Method that places a random word in a random place in the word grid. 
    // It also places when the answers are in the answer grid.

    public void placeWord(char[][] grid, String[] words, int[][] answer) {
        Random rand = new Random();
        int rows = grid.length;
        int columns = grid[0].length;

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            int len = word.length();
            int direction = rand.nextInt(5);
            int startRow, startCol;

            switch (direction) {
                case 0: // Horizontal
                    startRow = rand.nextInt(rows);
                    startCol = rand.nextInt(columns - len + 1);
                    for (int j = 0; j < len; j++) {
                        grid[startRow][startCol + j] = word.charAt(j);
                    }
                    answer[startRow][startCol] = wordIndex + 1;
                    answer[startRow][startCol + len - 1] = wordIndex + 1;
                    break;

                case 1: // Vertical
                    startRow = rand.nextInt(rows - len + 1);
                    startCol = rand.nextInt(columns);
                    for (int j = 0; j < len; j++) {
                        grid[startRow + j][startCol] = word.charAt(j);
                    }
                    answer[startRow][startCol] = wordIndex + 1;
                    answer[startRow + len - 1][startCol] = wordIndex + 1;
                    break;

                case 2: // Reverse Vertical
                    startRow = rand.nextInt(rows - len + 1);
                    startCol = rand.nextInt(columns);
                    for (int j = 0; j < len; j++) {
                        grid[startRow + len - 1 - j][startCol] = word.charAt(j);
                    }
                    answer[startRow][startCol] = wordIndex + 1;
                    answer[startRow + len - 1][startCol] = wordIndex + 1;
                    break;

                case 3: // Diagonal
                    startRow = rand.nextInt(rows - len + 1);
                    startCol = rand.nextInt(columns - len + 1);
                    for (int j = 0; j < len; j++) {
                        grid[startRow + j][startCol + j] = word.charAt(j);
                    }
                    answer[startRow][startCol] = wordIndex + 1;
                    answer[startRow + len - 1][startCol + len - 1] = wordIndex + 1;
                    break;

                case 4: // Other Diagonal
                    startRow = rand.nextInt(rows - len + 1) + len - 1;
                    startCol = rand.nextInt(columns - len + 1);
                    for (int j = 0; j < len; j++) {
                        grid[startRow - j][startCol + j] = word.charAt(j);
                    }
                    answer[startRow][startCol] = wordIndex + 1;
                    answer[startRow - len + 1][startCol + len - 1] = wordIndex + 1;
                    break;
            }
        }
    }
}