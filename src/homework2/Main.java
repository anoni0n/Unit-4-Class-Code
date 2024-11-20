package homework2;

public class Main {

    public static void main(String[] args) {
        vowelCounter("The quick brown fox jumped over the lazy dog.");
        System.out.println();
        vowelCounter("");
        System.out.println();
        palindromeChecker("level");
        System.out.println();
        palindromeChecker("abcde");
        System.out.println();
        palindromeChecker("1oLMLo1");
        System.out.println();
        palindromeChecker("aBbA");
        System.out.println();
        //extra credit
        palindromeChecker("s*dfj*js");
        System.out.println();
        palindromeChecker("jf&fj");

    }

    public static void vowelCounter(String str) {

        int count = 0;
        String vowels = "aeiou";
        int vowelIdx = 0;
        String tempStr = str.toLowerCase();
        //keeps counting while the letter being checked (vowels.atChar(vowelIdx)) exists
            while (vowelIdx < vowels.length()) {
                //checks if the letter being checked exists in the word
                if (tempStr.indexOf(vowels.charAt(vowelIdx)) != -1) {
                    count++;
                    //creates a substring that starts at the first instance of the letter so nothing is recounted.
                    tempStr = tempStr.substring(tempStr.indexOf(vowels.charAt(vowelIdx))+1);
                }
                else {
                    //moves to the next letter; prints and resets the count
                    System.out.println("Number of "+vowels.charAt(vowelIdx)+"'s: "+count);
                    tempStr = str.toLowerCase();
                    vowelIdx++;
                    count = 0;
                }
            }
    }

    public static void palindromeChecker(String word) {

        String drow = "";
        boolean validInput = true;
        //reverses the word and checks if each character is valid
        for (int i = word.length() - 1; i >= 0; i--){
            drow += word.charAt(i);
            if ((word.charAt(i) >= 33 && word.charAt(i) <= 47) || (word.charAt(i) >= 58 && word.charAt(i) <= 64) ||
                    (word.charAt(i)>=91 && word.charAt(i)<=96) || (word.charAt(i)>=123)){
                System.out.println("Error: Invalid character detected in "+word);
                validInput = false;
                break;
            }
        }
        //if the reversed word is the same as the original word, prints that word is a palindrome.
        if (word.equalsIgnoreCase(drow) && validInput){
            System.out.println(word+" is a palindrome");
        }
        else if (validInput){
            System.out.println(word+" is not a palindrome");
        }
    }
}