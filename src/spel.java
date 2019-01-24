import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class spel {
    public static void main(String[] args) {

        String correctWord = "test";

        char[] correctWord_array = correctWord.replaceAll("[a-öA-Ö]", "_").toCharArray();

        String[] state = {
               "  ---| \n" ,
               "  |  O \n" ,
               "  | -|-\n" ,
               "  | /\\ \n" ,
               " /---\\  \n" ,
               "/     \\  \n"
        };

        printWord(correctWord_array);
        int j = 0;
        while (j != state.length){

            Scanner tgb = new Scanner(System.in);
            System.out.println("Gissa på en bokstav");
            String gissning = tgb.next();

            if (correctWord.contains(gissning)) {
                for (int i = 0; i < correctWord.length(); i++) {
                    if (correctWord.charAt(i) == gissning.charAt(0)) {
                        correctWord_array[i] = gissning.charAt(0);
                        printWord(correctWord_array);
                    }
                }
            } else {
                printGubbe(state,j);
                j++;
            }
        }
    }
    private static void printGubbe(String[] gubbe, int j) {
        for (int i = 0; i < j+1; i++) {
            System.out.print(gubbe[i]);
        }
    }

    private static void printWord(char[] correctWord_array) {
        for (char c : correctWord_array) {
            System.out.print(c + " ");
        }
        System.out.println("\n");
    }

    private static String getRandomWord() {
        Scanner inputFile;
        try {
            inputFile = new Scanner (new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Filen finns inte, använd tangentbordet istället!");
            inputFile = new Scanner(System.in);
        }
        ArrayList<String> wordList = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            wordList.add(inputFile.nextLine());
        }

        Math.random();
        Random R = new Random ();
        int wordIndex = R.nextInt(wordList.size());
        return wordList.get(wordIndex);
    }
}