package Projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Wordle {
    public static void main(String[] args) {
        System.out.println("----------WORDLE----------");
        String green = "\u001B[42m";
        String yellow = "\u001B[43m";
        String colorReset = "\u001B[0m";
        String playing = "yes";
        String userGuess = "";
        Scanner userScanner = new Scanner(System.in);
        int guessNum = 1;

        while (playing.equalsIgnoreCase("yes")) {
            File wordFile = new File("src/Projects/WORDS");
            String word = null;
            try {
                Scanner fileScanner = new Scanner(wordFile);
                int x = (int)(Math.random()*3000);
                for (int i = 0; i < x; i++){
                    word = fileScanner.nextLine().toUpperCase();
                }
            } catch (Exception e) {System.out.println(e);}

            do {
                boolean validWord = false;
                while (!validWord) {
                    System.out.println("\nGuess a 5 letter word");
                    userGuess = userScanner.nextLine().toUpperCase();
                    try {
                        Scanner fileScanner = new Scanner(wordFile);
                        for (int i = 0; i < 3000; i++) {
                            String y = fileScanner.nextLine().toUpperCase();
                            if (y.equalsIgnoreCase(userGuess)) {
                                validWord = true;
                                break;
                            }
                            if (i==2999){
                                System.out.println("That is not a valid word. Try again!");
                            }
                        }
                    } catch (Exception e) {System.out.println(e);}
                }

                int correctChars = 0;
                int correctLocation = 0;
                String tempString = word;
                StringBuilder tempUpdate = new StringBuilder(tempString);
                StringBuilder guessUpdate = new StringBuilder(userGuess);
                ArrayList<String> displayWordArray = new ArrayList<>(Arrays.asList(userGuess.split("")));
                String displayReference = userGuess;

                for (int i = 0; i < word.length(); i++) {
                    //why can't I use .contains :(
                    for (int j = 0; j < word.length(); j++) {
                        if (userGuess.charAt(j) == tempString.charAt(j)) {
                            correctLocation++;
                            tempUpdate.setCharAt(j,' ');
                            tempString = tempUpdate.toString();
                            guessUpdate.setCharAt(j,'/');
                            userGuess = guessUpdate.toString();

                            displayWordArray.set(j, green + displayReference.charAt(j) +colorReset);
                        }
                    }
                        if (tempString.contains(userGuess.substring(i,i+1))) {
                            correctChars++;
                            tempUpdate.setCharAt(tempString.indexOf(userGuess.substring(i,i+1)),' ');
                            tempString = tempUpdate.toString();
                            displayWordArray.set(i, yellow + displayReference.charAt(i) + colorReset);
                        }
                }
                String displayWord = displayWordArray.toString().replaceFirst( "\\[","").replace("]", "").replace(",","").replace(" ","");
                System.out.println(displayWord);
                System.out.println(correctLocation + " in correct location.");
                System.out.println(correctChars + " correct letters (not in correct location).");
                guessNum++;
            } while (!userGuess.equals(word));
            System.out.printf("Congratulations! You guessed the word in %d tr%s! Would you like to play again? (yes/no)%n", guessNum, (guessNum > 1) ? "ies" : "y");
            playing = userScanner.nextLine();
        }
    }
}
