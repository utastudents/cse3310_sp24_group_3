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
    
    public char[][] createGrid(){
        char[][] grid = new char[rows][columns];

        Random random = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns;j++){
                char randomChar = (char)('A' + random.nextInt(26)); 
                grid[i][j] = Character.toString(randomChar);
            }
        }
        return grid;
    }

    public int[][] createAnswer() {
        int[][] answer = new int[rows][columns];
        return answer;
    }


    public void placeWord(char[][] grid, String[] word, int[][] answer) {
        Random rand = new Random();
        int len = word.length();

        for (String i: word) {
            // Randomly choose a direction: 0 = Horizontal, 1 = Vertical, 2 = Diagonal
            int direction = rand.nextInt(5);
            int startRow, startCol;

            switch (direction) {
                case 0: // Horizontal
                    startRow = rand.nextInt(rows);
                    startCol = rand.nextInt(columns-len+1); // Adjust for word length

                    // Placing characters in word grid
                    for (int j = 0; j < len; j++) {
                        grid[startRow][startCol + j] = String.valueOf(word.charAt(j));
                    }

                    // placing answers in answer grid
                    answer[startRow][startCol] = i;
                    answer[startRow][startCol+len-1] = i;

                    break;

                case 1: // Vertical
                    startRow = rand.nextInt(rows - len + 1); // Adjust for word length
                    startCol = rand.nextInt(columns);

                    for (int j = 0; j < len; j++) {
                        grid[startRow + j][startCol] = String.valueOf(word.charAt(j));
                    }

                    // placing answers in answer grid
                    answer[startRow][startCol] = i;
                    answer[startRow+len-1][startCol] = i;

                    break;

                case 2: // Reverse Vertical
                    startRow = rand.nextInt(rows - len + 1); // Adjust for word length
                    startCol = rand.nextInt(columns);

                    for (int j = len-1; j >= 0; j--) {
                        grid[startRow + j][startCol] = String.valueOf(word.charAt(j));
                    }

                    // placing answers in answer grid
                    answer[startRow][startCol] = i;
                    answer[startRow+len-1][startCol] = i;

                    break;

                case 3: // Diagonal
                    startRow = rand.nextInt(rows - len + 1); // Adjust for word length
                    startCol = rand.nextInt(columns - len + 1); // Adjust for word length

                    for (int j = 0; j < len; j++) {
                        grid[startRow + j][startCol + j] = String.valueOf(word.charAt(j));
                    }

                    // placing answers in answer grid
                    answer[startRow][startCol] = i;
                    answer[startRow+len-1][startCol+len-1] = i;
                    
                    break;

                case 4: // Other Diagonal
                    startRow = rand.nextInt(rows - len + 1) + len - 1; // Adjust for word length
                    startCol = rand.nextInt(columns - len + 1); // Adjust for word length

                    for (int j = 0; j < len; j++) {
                        grid[startRow - j][startCol + j] = String.valueOf(word.charAt(j));
                    }

                    // placing answers in answer grid
                    answer[startRow][startCol] = i;
                    answer[startRow-len+1][startCol+len-1] = i;
                    
                    break;
            }
        }
    }  
}

