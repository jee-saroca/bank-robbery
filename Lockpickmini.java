// Gonna add something that makes it not accept letter answers

import java.util.Scanner;

public class LockPickmini {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] lockCombination = generateCombination();
        
        System.out.println("Hurry up and pick the lock");
        System.out.println("You need to pick the lock by correctly setting the pins.");
        System.out.println("The lock has 4 pins. Each pin's value ranges from 0 to 9.");
        System.out.println("Enter your guess for each pin and try to unlock the door!");
        
// number of tries 
        for (int attempts = 1; attempts <= 5; attempts++) {
            System.out.println("\nAttempt " + attempts + ":");
            int[] playerGuess = getPlayerGuess(scanner);
            
            if (checkCombination(playerGuess, lockCombination)) {
                System.out.println("Grab whatevers in there and lets get out of here");
                return;
            } else {
                displayFeedback(playerGuess, lockCombination);
            }
        }
        
        System.out.println("\n You screwed up lets go.");
    }
    
  // Sets the random numbers 
    public static int[] generateCombination() {
        int[] combination = new int[4];
        for (int i = 0; i < 4; i++) {
            combination[i] = (int) (Math.random() * 10);
        }
        return combination;
    }
    
    // get the player's guess for the lock combination
    public static int[] getPlayerGuess(Scanner scanner) {
        int[] guess = new int[4];
        System.out.print("Enter your guess (4 numbers separated by spaces): ");
        for (int i = 0; i < 4; i++) {
            guess[i] = scanner.nextInt();
        }
        return guess;
    }
    

    public static boolean checkCombination(int[] guess, int[] combination) {
        for (int i = 0; i < 4; i++) {
            if (guess[i] != combination[i]) {
                return false;
            }
        }
        return true;
    }
    
// This can be used as easy mode though not sure
    public static void displayFeedback(int[] guess, int[] combination) {
        System.out.print("Feedback: ");
        for (int i = 0; i < 4; i++) {
            if (guess[i] == combination[i]) {
                System.out.print("Correct ");
            } else if (guess[i] < combination[i]) {
                System.out.print("Higher ");
            } else {
                System.out.print("Lower ");
            }
        }
        System.out.println();
    }
}
