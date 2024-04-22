package uta.cse3310;
import java.util.Random;

public class WordGrid {
    public WordBank bank;
    public String[] words;
    public User user;
    public int rows = 25;
    public int columns = 25;

    public String[] wordsCreated(){
        int numWords = 10; 
        String filePath = "words.txt";
        words = WordBank.generateRandomWords(numWords, filePath);
        return words;
    }
    
    public String[][] createGrid(){
        String[][] grid = new String[rows][columns];

        Random random = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns;j++){
                char randomChar = (char)('A' + random.nextInt(26)); 
                grid[i][j] = Character.toString(randomChar);
            }
        }
        return grid;
    }


    public void placeWord(String[][] grid, String word) {
        Random rand = new Random();
        int len = word.length();
        boolean placed = false;

        while (!placed) {
            // Randomly choose a direction: 0 = Horizontal, 1 = Vertical, 2 = Diagonal
            int direction = rand.nextInt(3);
            int startRow, startCol;

            switch (direction) {
                case 0: // Horizontal
                    startRow = rand.nextInt(rows);
                    startCol = rand.nextInt(columns - len + 1); // Adjust for word length
                    for (int i = 0; i < len; i++) {
                        grid[startRow][startCol + i] = String.valueOf(word.charAt(i));
                    }
                    placed = true;
                    break;
                case 1: // Vertical
                    startRow = rand.nextInt(rows - len + 1); // Adjust for word length
                    startCol = rand.nextInt(columns);
                    for (int i = 0; i < len; i++) {
                        grid[startRow + i][startCol] = String.valueOf(word.charAt(i));
                    }
                    placed = true;
                    break;
                case 2: // Diagonal
                    startRow = rand.nextInt(rows - len + 1); // Adjust for word length
                    startCol = rand.nextInt(columns - len + 1); // Adjust for word length
                    for (int i = 0; i < len; i++) {
                        grid[startRow + i][startCol + i] = String.valueOf(word.charAt(i));
                    }
                    placed = true;
                    break;
            }
        }
    }  
}

