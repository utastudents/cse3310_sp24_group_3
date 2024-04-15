package uta.cse3310;
import java.util.List;

public class GameBoard {
    private char[][] letterGrid;
    private List<String> validWords;

    public GameBoard(int rows, int columns) {
        letterGrid = new char[rows][columns];
    }
    public void initializeGrid() {
        // This method needs a return type and perhaps parameters to specify how to initialize the grid.
        for(int i=0; i<letterGrid.length; i++){
            for(int j = 0; i < letterGrid[i].length; j++){
                letterGrid[i][j] = '-';
            }
        }
    }

    public void highlightWord() {
        // This method needs a return type and perhaps parameters to specify which word to highlight.
    }

    public boolean isValidWord(String word) {
        return validWords.contains(word);
    }

    public static void letterGrid() {
        
    }

    // Getters and Setters for letterGrid and validWords
    public char[][] getLetterGrid() {
        return letterGrid;
    }

    public void setLetterGrid(char[][] letterGrid) {
        this.letterGrid = letterGrid;
    }

    public List<String> getValidWords() {
        return validWords;
    }

    public void setValidWords(List<String> validWords) {
        this.validWords = validWords;
    }
}
