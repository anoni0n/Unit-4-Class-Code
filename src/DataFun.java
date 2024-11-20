import java.util.Scanner;

/**
 * Description goes here
 * @author [Ananya Ilanchelian]
 * @version [11/5/2024]
 */public class DataFun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //gets the user's favorite character.
        System.out.println("What is your favorite integer?");
        int userNumber = scanner.nextInt();
        //prints if the number is positive or negative
        if (userNumber>=0){
            System.out.println(userNumber+" is positive.");
        }
        else {
            System.out.println(userNumber+" is positive.");
        }
        //prints the greatest power of 10 from 10^1 to 10^3 that the number is greater than.
        if (userNumber>1000){
            System.out.println(userNumber+" is greater than 1000.");
        }
        else if (userNumber>100){
            System.out.println(userNumber+" is greater than 100.");
        }
        else if (userNumber>10){
            System.out.println(userNumber+" is greater than 10.");
        }
        //prints the parity of a number
        if (userNumber%2 == 0){
            System.out.println(userNumber+" is even.");
        }
        else {
            System.out.println(userNumber+" is odd.");
        }
        //prints the noble gas that the number corresponds to.
        switch(userNumber){
            case 2: System.out.println(userNumber+" is the atomic number of the noble gas Helium.");
                break;
            case 10: System.out.println(userNumber+" is the atomic number of the noble gas Neon.");
                break;
            case 18: System.out.println(userNumber+" is the atomic number of the noble gas Argon.");
                break;
            case 36: System.out.println(userNumber+" is the atomic number of the noble gas Krypton.");
                break;
            case 54: System.out.println(userNumber+" is the atomic number of the noble gas Xenon.");
                break;
            case 86: System.out.println(userNumber+" is the atomic number of the noble gas Radon.");
                break;
            case 118: System.out.println(userNumber+" is the atomic number of the noble gas Oganesson.");
                break;
            default: System.out.println(userNumber+" doesn't correspond to the atomic number of any noble gas.");
        }
        //gets the user's favorite character.
        System.out.println("\nWhat is your favorite character?");
        scanner.nextLine();
        char userChar = scanner.nextLine().charAt(0);
        int charASCII = userChar;
        String suffix = getSuffix(charASCII);

        //prints that the character is a number if it is within a certain ASCII range.
        if (charASCII >= 48 && charASCII <=57 ){
            System.out.println(userChar+" is a number.");
            System.out.println(userChar+" has an ASCII value of 1"+charASCII+".");
        }
        //prints that the character is an uppercase letter if it is within a certain ASCII range.
        else if (charASCII >= 65 && charASCII <= 90){
            System.out.println(userChar+" is an uppercase letter.");
            //checks if the letter is a vowel by seeing whether it is in a substring containing all vowels.
            if ("AEIOU".indexOf(userChar) != -1 ) {
                System.out.println(userChar+" is a vowel.");
            }
            else{
                System.out.println(userChar+" is not a vowel.");
            }
            System.out.println(userChar+" has an ASCII value of "+charASCII+".");
            System.out.println(userChar+" is the "+(charASCII-64)+suffix+" letter of the alphabet.");
        }
        //prints that the character is a lowercase letter if it is within a certain ASCII range.
        else if(charASCII >= 97 && charASCII <= 122){
            System.out.println(userChar+" is a lower case letter.");
            //checks if the letter is a vowel by seeing whether it is in a substring containing all vowels
            if ("aeiou".indexOf(userChar) != -1 ) {
                System.out.println(userChar+" is a vowel.");
            }
            else{
                System.out.println(userChar+" is not a vowel.");
            }
            System.out.println(userChar+" has an ASCII value of "+charASCII+".");
            System.out.println(userChar+" is the "+(charASCII-96)+suffix+" letter of the alphabet.");
        }
        //prints that the character is not a number, uppercase letter, or lowercase letter.
        else {
            System.out.println(userChar+" is not a number or a letter.");
            System.out.println(userChar+" has an ASCII value of "+charASCII+".");
        }
    }

    private static String getSuffix(int charASCII) {
        int letterNumber = charASCII;
        //finds the letter of the alphabet of a character from its ASCII value.
        if (charASCII >= 97){
            letterNumber -= 96;
        }
        else {
            letterNumber -=64;
        }
        //gets the suffix that corresponds with the last digit of the character's letter number.
        return switch (letterNumber % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            case 4, 5, 6, 7, 9 -> "th";
            default -> "";
        };
    }
}