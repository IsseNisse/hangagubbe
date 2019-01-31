import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class spel {
    public static void main(String[] args) {

        String correctWord = getRandomWord();

        char[] underscore = correctWord.replaceAll("[a-öA-Ö]", "_").toCharArray();

        String[] state = {
               "  ---| \n" ,
               "  |  O \n" ,
               "  | -|-\n" ,
               "  | /\\ \n" ,
               " /---\\  \n" ,
               "/     \\  \n"
        };

        printWord(underscore);
        int j = 0;
        int score = 0;
        while (j != state.length && score < correctWord.length()){

            Scanner tgb = new Scanner(System.in);
            System.out.println("Gissa på en bokstav");
            String gissning = tgb.next();

            if (correctWord.contains(gissning)) {
                for (int i = 0; i < correctWord.length(); i++) {
                    if (correctWord.charAt(i) == gissning.charAt(0)) {
                        score++;
                        underscore[i] = gissning.charAt(0);
                        printWord(underscore);
                    }
                }
            } else {
                printGubbe(state,j);
                j++;
            }
            if (j == 6) {
                System.out.println("Du förlorade! Ordet var " + correctWord);
            }
            if (score == correctWord.length()){
                System.out.println("Du vann");
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