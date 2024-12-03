package Projects;

import java.util.Scanner;
import java.io.File;

public class Woodle {
    public static void main(String[] args) {
        System.out.println("----------WOODLE----------");
        String playing = "yes";
        String userGuess = "";
        Scanner userScanner = new Scanner(System.in);
        int guessNum = 1;
        //repeats the game while the user says yes
        while (playing.equalsIgnoreCase("yes")) {
            File wordFile = new File("src/Projects/WORDS");
            String word = null;
            try {
                Scanner fileScanner = new Scanner(wordFile);
                int x = (int)(Math.random()*6102);
                for (int i = 0; i < x; i++){
                    word = fileScanner.nextLine().toUpperCase();
                }
            } catch (Exception e) {System.out.println(e);}
            //prompts the user to keep guessing while their guess is not correct
            while (!userGuess.equals(word)) {
                boolean validWord = false;
                System.out.println("\nGuess a 5 letter word");
                //checks if the user's guess is in WORDS
                while (!validWord) {
                    userGuess = userScanner.nextLine().toUpperCase();
                    try {
                        Scanner fileScanner = new Scanner(wordFile);
                        for (int i = 0; i < 6102; i++) {
                            String y = fileScanner.nextLine().toUpperCase();
                            if (y.equalsIgnoreCase(userGuess)) {
                                validWord = true;
                                break;
                            }
                            if (i==6101){
                                System.out.println("That is not a valid word. Try again!");
                            }
                        }
                    } catch (Exception e) {System.out.println("That is not a valid word. Try again!");}
                }

                int correctChars = 0;
                int correctLocation = 0;
                String wordCompare = word;
                String userGuessCompare = userGuess;
                //outer loop checks for correct position
                for (int i = 0; i < word.length(); i++) {
                    //inner loop checks for letters in the right position and removes them from userGuessCompare and wordCompare to avoid over counting
                    for (int j = 0; j < word.length(); j++) {
                        if (userGuessCompare.substring(j, j + 1).equals(wordCompare.substring(j, j + 1))) {
                            correctLocation++;
                            String firstHalf = wordCompare.substring(0, j);
                            String guessFirstHalf = userGuessCompare.substring(0, j);
                            String secondHalf;
                            String guessSecondHalf;
                            //removes matching chars from both strings being compared. The else is so the second halves don't go out of bounds for j+1
                            if (j +1<word.length()){
                                secondHalf = wordCompare.substring(j +1);
                                guessSecondHalf = userGuessCompare.substring(j +1);
                            }
                            else {
                                secondHalf = "";
                                guessSecondHalf = "";
                            }
                            wordCompare = firstHalf + " " + secondHalf;
                            userGuessCompare = guessFirstHalf+"/"+guessSecondHalf;
                        }
                    }
                    int charCheckIdx = wordCompare.indexOf(userGuessCompare.substring(i, i + 1));
                    //checks if each char in wordCompare exists in userGuessCompare and removes those chars from both strings to avoid over counting
                    if (charCheckIdx != -1) {
                        correctChars++;
                        String firstHalf2 = wordCompare.substring(0,charCheckIdx);
                        String secondHalf2;
                        if (i+1<word.length()){
                            secondHalf2 = wordCompare.substring(charCheckIdx+1);
                        }
                        else {
                            secondHalf2 = "";
                        }
                        wordCompare = firstHalf2 + " " + secondHalf2;
                    }
                }
                System.out.println(correctLocation + " in correct location.");
                System.out.println(correctChars + " correct letters (not in correct location).");
                guessNum++;
            }
            System.out.printf("Congratulations! You guessed the word in %d tr%s! Would you like to play again? (yes/no)%n", guessNum, (guessNum > 1) ? "ies" : "y");
            playing = userScanner.nextLine();
        }
    }
}