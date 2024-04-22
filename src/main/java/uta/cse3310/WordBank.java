
package uta.cse3310;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordBank {
    private int density;

    public void setDensity(int density) {
        this.density = density;
    }
    
    public static String[] generateRandomWords(int numWords, String filePath) {
        List<String> words = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return new String[0]; // return empty if file not found
        }

        Random random = new Random();
        String[] selectedWords = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            int randomIndex = random.nextInt(words.size());
            selectedWords[i] = words.get(randomIndex);
        }
        return selectedWords;
    }
}
