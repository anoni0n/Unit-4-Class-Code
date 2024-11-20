
# Assignment Instructions

**Attach your .java file to the Google Classroom assignment.**  
The file must be named `Unit4HW2.java`.

You can find the starter code at this link: [Unit4HW2.java Starter Code](https://github.com/WLHS-APCSA-2023/Unit-4-Code/blob/main/Unit4HW2.java).

Complete each method in the provided starter file.

---

## **Problem 1: Vowel Counter**

Implement the `vowelCounter` method, which takes a `String` as input and counts the occurrences of each vowel (A, E, I, O, U) in the input string. The method should be case-insensitive (e.g., both 'a' and 'A' count as 'A'). After processing the input, display the count for each vowel.

**Example:**

```java
vowelCounter("The quick brown fox jumped over the lazy dog.");
```

**Expected Output:**
```
Number of a's: 1  
Number of e's: 4  
Number of i's: 1  
Number of o's: 4  
Number of u's: 2  
```

---

## **Problem 2: Palindrome Checker**

Implement the `palindromeChecker` method, which checks if a given `String` is a palindrome. A palindrome reads the same backward as forward. For this problem, ignore spaces and assume input will contain only alphanumeric characters.

**Extra Credit (2 pts):**  
Modify the method to validate input and only accept alphanumeric characters. If the input contains non-alphanumeric characters, the method should print:
```
Error: Invalid character detected in [input]
```

**Example Calls and Expected Output:**

```java
palindromeChecker("level");
System.out.println();
palindromeChecker("abcde");
System.out.println();
palindromeChecker("racecar");
System.out.println();
palindromeChecker("aBbA");
System.out.println();

// Extra credit cases
palindromeChecker("s*dfj*js");
System.out.println();
palindromeChecker("jf&fj");
```

**Output:**
```
level is a palindrome.  

abcde is not a palindrome.  

racecar is a palindrome.  

abba is a palindrome.  

Error: Invalid character detected in s*dfj*js  

Error: Invalid character detected in jf&fj  
```

**Hint:**  
You might find `break`, `continue`, and/or `return` helpful depending on your approach.
