package Projects;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Woodle {
    public static void main(String[] args) {
        System.out.println("----------WOODLE----------");
        String playing = "yes";
        int correctLocation = 0;
        int correctChars = 0;
        String userGuess = "";

        while (playing.equalsIgnoreCase("yes")) {
            Scanner userScanner = new Scanner(System.in);
            File wordFile = new File("src/Projects/WORDS");
            String word = null;
            try {
                Scanner fileScanner = new Scanner(wordFile);
                int x = (int) (Math.random() * 3603);
                for (int i = 0; i < x; i++) {
                    word = fileScanner.nextLine().toUpperCase();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            ArrayList<String> validCharCheck = new ArrayList<>();
            ArrayList<String> userGuessCheck = new ArrayList<>();
            int guessNum = 0;

            while (!userGuess.equals(word)) {
                System.out.println("\nGuess a 5 letter word:");
                boolean validWord = false;
                while (!validWord) {
                    userGuess = userScanner.nextLine().toUpperCase();
                    try {
                        Scanner fileScanner = new Scanner(wordFile);
                        for (int i = 0; i < 3104; i++) {
                            String y = fileScanner.nextLine().toUpperCase();
                            if (y.equalsIgnoreCase(userGuess)) {
                                validWord = true;
                                break;
                            }
                            if (i == 3103) {
                                System.out.println("That is not a valid word. Try again!");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("That is not a valid word. Try again!");
                    }
                }
                validCharCheck.clear();
                userGuessCheck.clear();
                for (int i = 0; i < word.length(); i++) {
                    validCharCheck.add(word.substring(i, i + 1));
                    userGuessCheck.add(userGuess.substring(i,i+1));
                }

                for (int i = 0; i < word.length(); i++) {
                    //why can't I use .contains :(
                    for (int j = 0; j < word.length(); j++) {
                        if (userGuess.substring(j, j + 1).equals(word.substring(j, j + 1)) && !validCharCheck.get(j).equals(" ")) {
                            correctLocation++;
                            validCharCheck.set(j, " ");
                            userGuessCheck.set(j, " ");
                        }
                    }
                    int charCheckIdx = validCharCheck.indexOf(userGuess.substring(i, i + 1));
                    if (charCheckIdx != -1 && !validCharCheck.get(charCheckIdx).equals(" ") && !userGuessCheck.get(i).equals(" ")) {
                        correctChars++;
                        validCharCheck.set(charCheckIdx, " ");
                    }
                }
                System.out.println(correctLocation + " in correct location.");
                System.out.println(correctChars + " correct letters (not in correct location).");
                guessNum++;
                correctChars = 0;
                correctLocation = 0;
            }
            System.out.printf("%nCongratulations! You guessed the word in %d tr%s! Would you like to play again? (yes/no)%n", guessNum, (guessNum > 1) ? "ies" : "y");
            playing = userScanner.nextLine();
        }
    }
}