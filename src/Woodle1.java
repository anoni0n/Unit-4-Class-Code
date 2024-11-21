import java.util.Arrays;
import java.util.Scanner;

public class Woodle1 {
    public static void main(String[] args) {
        System.out.println("----------WOODLE----------");
        String playing = "yes";
        Scanner scanner = new Scanner(System.in);
        int guessNum = 1;

        while (playing.equalsIgnoreCase("yes")) {

            char[] word = "Hello".toUpperCase().toCharArray();
            System.out.println("Guess A 5 Letter Word:");
            char[] userGuess = scanner.nextLine().toUpperCase().toCharArray();

            while (!Arrays.equals(word, userGuess)) {
                for (int i = 0; i<word.length;i++){
                    
                }
            }
        }
    }
}
