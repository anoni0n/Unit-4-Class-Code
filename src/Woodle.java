import java.util.Scanner;

public class Woodle {
    public static void main(String[] args) {
        System.out.println("----------WOODLE----------");
        String playing = "yes";
        while (playing.equalsIgnoreCase("yes")) {
            String word = "LOLLY";
            System.out.println("\nGuess A 5 Letter Word:");
            Scanner scanner = new Scanner(System.in);
            String userGuess = scanner.nextLine().toUpperCase();
            int guessNum = 1;

            while (!userGuess.equals(word)) {
                int correctChars = 0;
                int correctLocation = 0;
                String tempString = word;

                for (int i = 0; i < word.length(); i++) {
                    System.out.println(i);
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
                            System.out.println("tempString(j): "+tempString);
                            System.out.println("userGuess(j):  "+userGuess);
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
                        System.out.println("tempString(i): "+tempString);
                        System.out.println("userGuess(i):  "+userGuess);
                    }
                }
                System.out.println(correctLocation + " in correct location.");
                System.out.println(correctChars + " correct letters (not in correct location).");
                System.out.println("\nGuess a 5 letter word");
                userGuess = scanner.nextLine().toUpperCase();
                guessNum++;
            }
            System.out.printf("Congratulations! You guessed the word in %d tr%s! Would you like to play again? (yes/no)%n", guessNum, (guessNum > 1) ? "ies" : "y");
            playing = scanner.nextLine();
        }
    }
}
