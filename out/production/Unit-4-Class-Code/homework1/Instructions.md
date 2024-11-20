Attach your .java file to the Google Classroom assignment. It must be called Unit4HW1.java

Start code is at [https://github.com/WLHS-APCSA/Unit-4-Class-Code/tree/main/src/homework1](https://github.com/WLHS-APCSA/Unit-4-Class-Code/tree/main/src/homework1). You need to put your code in each method.

**Problem 1: Guessing Game**

Write a Java program that picks a random number between 1 and 100 and asks the user to guess it. For each guess, the program should tell the user whether the guess is too high, too low, or correct. The game should continue using a while loop until the user guesses the correct number.

Sample Output
```
Guess the number: 50
Too high\! Try again.
Guess the number: 25
Too low\! Try again.
Guess the number: 37
Correct\! You've guessed the right number\!
```

**Problem 2: Tired Turtle**

Background: Imagine there's a turtle in a straight line path. Initially, it starts from position 0\. The turtle can move forward a whole number of steps but has a peculiar behavior. Every time you command it to move, it moves a certain number of steps, but gets tired and moves half the number of steps the next time, and then half of that the next time, and so on. The turtle stops moving when it can't move a full step anymore.

Problem: Write a Java program that asks the user how many steps they want the turtle to take in its first move. Then calculate and print how many total steps the turtle took until it stopped, using a while loop.

Sample output:

```
How many steps should the turtle take in its first move? 10
Total steps taken by the turtle: 18
```

Explanation  
First move: 10 steps  
Second move: 5 steps (half of 10\)  
Third move: 2 steps (half of 5, rounded down)  
Fourth move: 1 step (half of 2\)  
Fifth move: 0 steps (half of 1, rounded down)  
Total \= 10 \+ 5 \+ 2 \+ 1 \+ 0 \= 18 steps

**Problem 3: Not Tamagotchi**

Background: You have a virtual pet, and it gets hungry over time. Every hour, its hunger level increases. However, you can feed the pet to decrease its hunger level. If the hunger level reaches a certain threshold, your pet will become unhappy.

Problem: Write a Java program to simulate the hunger level of your virtual pet over time.

1. Start with a hunger level of 0\.
2. Every hour (iteration), increase the hunger level by 10.
3. Ask the user if they want to feed the pet.
4. If the user feeds the pet, decrease the hunger level by 25 (ensure it doesn't go below 0).
5. If the hunger level reaches 40 or above, inform the user that the pet is unhappy.
6. End the simulation after 5 hours or if the user decides not to feed the pet when it's unhappy.

Sample Outputs:

```
Hour 1: Current hunger level is 10 Do you want to feed your pet? (yes/no): no 
Hour 2: Current hunger level is 20 Do you want to feed your pet? (yes/no): yes 
Hour 3: Current hunger level is 10 Do you want to feed your pet? (yes/no): no 
Hour 4: Current hunger level is 20 Do you want to feed your pet? (yes/no): no 
Hour 5: Current hunger level is 30 End of simulation. Your pet is content.  
```
```
Hour 1: Current hunger level is 10 Do you want to feed your pet? (yes/no): no 
Hour 2: Current hunger level is 20 Do you want to feed your pet? (yes/no): no 
Hour 3: Current hunger level is 30 Do you want to feed your pet? (yes/no): no 
Hour 4: Current hunger level is 40 Feed your animal soon, it is unhappy. 
Do you want to feed your pet? (yes/no): no End of simulation. Your pet is dead.  
```
```
Hour 1: Current hunger level is 10 Do you want to feed your pet? (yes/no): yes 
Hour 2: Current hunger level is 10 Do you want to feed your pet? (yes/no): no 
Hour 3: Current hunger level is 20 Do you want to feed your pet? (yes/no): yes 
Hour 4: Current hunger level is 10 Do you want to feed your pet? (yes/no): no 
Hour 5: Current hunger level is 20 End of simulation. Your pet is content.
```
