import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class spel {
    public static void main(String[] args) {

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
        String correctWord = wordList.get(wordIndex);
        //String word = correctWord + correctWord.length();

       String correctWord_ = correctWord.replaceAll("[a-öA-Ö]", "_ ");
       System.out.println(correctWord_);
       System.out.println(correctWord);

       Scanner tgb = new Scanner(System.in);
       System.out.println("Gissa på en bokstav");
       String gissning = tgb.next();
       for () {
           if (correctWord.contains(gissning)) {
               correctWord_.replace
           } else {
               System.out.println("Fel!");
           }
       }


    }
}