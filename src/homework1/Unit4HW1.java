package homework1;

import java.util.Scanner;

public class Unit4HW1 {

    public static void main(String[] args) {
        guessingGame();
        tiredTurtle();
        notATamagotchi();
        int bob = 5;
        System.out.println(bob);
        bob = 8;


    }

    /**
     * Picks a random number between 1 and 100 and asks the user
     * to guess it. For each guess, the program should tell the user whether
     * the guess is too high, too low, or correct.
     *
     */
    public static void guessingGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess my number (1-100):");
        int random = (int)(Math.random()*100)+1;
        int userGuess = scanner.nextInt();
        while (userGuess != random) {
            if (userGuess < 1 || userGuess > 100){
                System.out.println("That number is not in range. Try again!");
            }
            else if (userGuess < random) {
                System.out.println("Too low; try again!");
            }
            else {
                System.out.println("Too high; try again!");
            }
            userGuess = scanner.nextInt();
        }
        System.out.println("Correct! Congratulations!");
    }

    /**
     * Tired Turtle
     * Asks the user how many steps they want the turtle to take in its
     * first move. Then it calculates and displays how many total steps
     * the turtle took until it stopped.
     *
     */
    public static void tiredTurtle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHow many steps should the turtle take in its first move?");
        int nextSteps = scanner.nextInt();
        int totalSteps = nextSteps;
        while (nextSteps >= 2){
            nextSteps /= 2;
            totalSteps += nextSteps;
        }
        System.out.println("Total steps taken by the turtle: "+totalSteps+"\n");
    }



    /**
     * Write your own description
     */
    public static void notATamagotchi(){

        Scanner scanner = new Scanner(System.in);
        int hungerLevel = 10;
        int hour = 1;
        boolean happy = true;

        while (hour < 5 && happy) {

            if (hungerLevel < 40) {
                System.out.println("Hour " + hour + ": Current hunger level is " + hungerLevel + ". Do you want to feed your pet? (yes/no):");
            } else {
                happy = false;
                System.out.println("Hour " + hour + ": Current hunger level is " + hungerLevel + ". Your pet is unhappy. Do you want to feed your pet? (yes/no):");
            }
            String userAnswer = scanner.nextLine();
            //feeds the !Tamagotchi;
            if (userAnswer.equalsIgnoreCase("yes") && hungerLevel < 25) {
                happy = true;
                hungerLevel = 0;
            }
            //makes it so hungerLevel doesn't go negative
            else if (userAnswer.equalsIgnoreCase("yes")) {
                happy = true;
                hungerLevel -= 25;
            }
            hungerLevel += 10;
            hour++;
        }
        //status after simulation
        System.out.printf("Hour "+hour+": End of simulation. Your pet is %s.", happy ? "content" : "dead");
    }
}
