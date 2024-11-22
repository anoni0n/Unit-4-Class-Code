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
        String word = "";
        String userGuess = "";
        Scanner userScanner = new Scanner(System.in);
        int guessNum = 1;

        //asks the user if they want to keep playing
        while (playing.equalsIgnoreCase("yes")) {
            File wordFile = new File("src/Projects/WORDS");
            //generates a random word by scanning a random line in WORDS
            try {
                Scanner fileScanner = new Scanner(wordFile);
                int x = (int)(Math.random()*3000);
                for (int i = 0; i < x; i++){
                    word = fileScanner.nextLine().toUpperCase();
                }
            } catch (Exception e) {System.out.println(e);}

            //prompts the user to keep guessing while their guess is wrong
            while (!userGuess.equals(word)) {
                boolean validWord = false;
                //checks if the user's guess is in WORDS
                while (!validWord) {
                    System.out.println("\nGuess a 5 letter word");
                    userGuess = userScanner.nextLine().toUpperCase();
                    try {
                        Scanner fileScanner = new Scanner(wordFile);
                        for (int i = 0; i < 3104; i++) {
                            String y = fileScanner.nextLine().toUpperCase();
                            if (y.equalsIgnoreCase(userGuess)) {
                                validWord = true;
                                break;
                            }
                            if (i==3103){
                                System.out.println("That is not a valid word. Try again!");
                            }
                        }
                    } catch (Exception e) {System.out.println("That is not a valid word. Try again!");}
                }
                //checks if the word is correct before userGuess is modified for the other checks
                if (userGuess.equalsIgnoreCase(word)){
                    break;
                }
                //not used right now, but I might add the counts back later
                //int correctChars = 0;
                //int correctLocation = 0;
                String tempString = word;
                StringBuilder tempUpdate = new StringBuilder(tempString);
                StringBuilder guessUpdate = new StringBuilder(userGuess);
                ArrayList<String> displayWordArray = new ArrayList<>(Arrays.asList(userGuess.split("")));
                String displayReference = userGuess;

                for (int i = 0; i < word.length(); i++) {
                    //compares each letter of userGuess to the corresponding character in tempString,
                    //then removes matching characters from both strings to avoid over counting in the next step
                    for (int j = 0; j < word.length(); j++) {
                        if (userGuess.charAt(j) == tempString.charAt(j)) {
                            //correctLocation++;
                            tempUpdate.setCharAt(j,' ');
                            tempString = tempUpdate.toString();
                            //replace the characters in userGuess with " " instead of " " so they don't show as a match in the next step
                            guessUpdate.setCharAt(j,'/');
                            userGuess = guessUpdate.toString();

                            displayWordArray.set(j, green + displayReference.charAt(j) +colorReset);
                        }
                    }
                        //checks if there is an instance of userGuess.charAt(i) in tempString, and removes that instance from tempString if there
                        //is to avoid over counting
                        if (tempString.contains(userGuess.substring(i,i+1))) {
                            //correctChars++;
                            tempUpdate.setCharAt(tempString.indexOf(userGuess.substring(i,i+1)),' ');
                            tempString = tempUpdate.toString();
                            displayWordArray.set(i, yellow + displayReference.charAt(i) + colorReset);
                        }
                }
                String displayWord = displayWordArray.toString().replaceFirst( "\\[","").replace("]", "").replace(",","").replace(" ","");
                System.out.println(displayWord);
                //System.out.println(correctChars);
                //System.out.println(correctLocation);
                guessNum++;
            }
            System.out.printf("Congratulations! You guessed the word in %d tr%s! Would you like to play again? (yes/no)%n", guessNum, (guessNum > 1) ? "ies" : "y");
            playing = userScanner.nextLine();
        }
    }
}