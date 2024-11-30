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


            while (!userGuess.equals(word)) {
                boolean validWord = false;
                System.out.println("\nGuess a 5 letter word");
                //checks if the user's guess is in WORDS
                while (!validWord) {
                    userGuess = userScanner.nextLine().toUpperCase();
                    try {
                        Scanner fileScanner = new Scanner(wordFile);
                        for (int i = 0; i < 3603; i++) {
                            String y = fileScanner.nextLine().toUpperCase();
                            if (y.equalsIgnoreCase(userGuess)) {
                                validWord = true;
                                break;
                            }
                            if (i==3602){
                                System.out.println("That is not a valid word. Try again!");
                            }
                        }
                    } catch (Exception e) {System.out.println("That is not a valid word. Try again!");}
                }

                if (userGuess.equals(word)){
                    break;
                }

                int correctChars = 0;
                int correctLocation = 0;
                String tempString = word;

                for (int i = 0; i < word.length(); i++) {
                    //why can't I use .contains :(
                    for (int j = 0; j < word.length(); j++) {
                        if (userGuess.substring(j, j + 1).equals(tempString.substring(j, j + 1))) {
                            correctLocation++;
                            String firstHalf = tempString.substring(0, j);
                            String guessFirstHalf = userGuess.substring(0, j);
                            String secondHalf;
                            String guessSecondHalf;
                            if (j +1<word.length()){
                                secondHalf = tempString.substring(j +1);
                                guessSecondHalf = userGuess.substring(j +1);
                            }
                            else {
                                secondHalf = "";
                                guessSecondHalf = "";
                            }
                            tempString = firstHalf + " " + secondHalf;
                            userGuess = guessFirstHalf+"/"+guessSecondHalf;
                        }
                    }
                    int charCheckIdx = tempString.indexOf(userGuess.substring(i, i + 1));
                    if (charCheckIdx != -1) {
                        correctChars++;
                        String firstHalf2 = tempString.substring(0,charCheckIdx);
                        String secondHalf2;
                        if (i+1<word.length()){
                            secondHalf2 = tempString.substring(charCheckIdx+1);
                        }
                        else {
                            secondHalf2 = "";
                        }
                        tempString = firstHalf2 + " " + secondHalf2;
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