import java.util.Random;
import java.util.Scanner;
public class YellAtTeller {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		// STATS
		int intellect = 0;
		int strength = 0;
		int sneak = 0;
		int intimidate = 0;
		int money = 0;
		
		// strings
		String partnerName = "PARTNER";
		String toolName = "TOOL"; 
		
		System.out.println("You chose to yell at the bank teller.");
		
		
		System.out.println("You kick the door open and head towards the Bank Teller pointing your gun at them.");
		//delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
		//delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
		//delaySpeech(2);
		System.out.println("The teller points to the back");
		//delaySpeech(2);
        System.out.println("YOU: OPEN THE DOOR NOW!!!!!");
		//delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not here.");
		//delaySpeech(2);
        System.out.println("YOU: DAMN!!!! OK LET'S SEE IF I COULD LOCK PICK THIS THEN!!!!");
		//delaySpeech(2);
    	boolean resultOfLockPick = LockPickMini(partnerName);
		
		if(resultOfLockPick) {
			System.out.println("YOU: Ok, let's get a move on buddy.");
			//delaySpeech(2);
			System.out.println("The Bank Teller takes you to the vault.");
			//delaySpeech(2);
			System.out.println("YOU: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
			//delaySpeech(2);
			System.out.println("Bank Teller: It's, 6-4-2. That's the code for the vault.");
			//delaySpeech(2);
			System.out.println("Bank Teller: Ok, there it's open.");
			//delaySpeech(2);
			System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
			//delaySpeech(3);
			System.out.println("You takes out his bag and collects money from the vault.");
			//delaySpeech(3);
			money += 190000;
			System.out.println("YOU: OK, Got the dough. Lets go.");
			//delaySpeech(3);
			System.out.println(partnerName + ": Got it. Let's go to the back door.");
		} else {
			System.out.println("YOU: Ok, let's get a move on buddy.");
			//delaySpeech(2);
			System.out.println("The Bank Teller takes you to the vault.");
			//delaySpeech(2);
			System.out.println("YOU: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
			//delaySpeech(2);
			System.out.println("Bank Teller: It's, 6-4-2. That's the code for the vault.");
			//delaySpeech(2);
			System.out.println("Bank Teller: Ok, there it's open.");
			//delaySpeech(2);
			System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
			//delaySpeech(3);
			System.out.println("You takes out his bag and collects money from the vault.");
			//delaySpeech(3);
			money += 155000;
			System.out.println("YOU: OK, Got the dough. Lets go.");
			//delaySpeech(3);
			System.out.println(partnerName + ": Got it. Let's go to the back door.");
		}
		
		//delaySpeech(2);
        System.out.println("YOU: Ok, meet you there.");
		System.out.println("You meet up with " + partnerName +
						  " and escape to the car.");
	}
	
	public static boolean LockPickMini(String partnerName) {
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
                System.out.println("The door is unlocked.");
                return true;
            } else {
                displayFeedback(playerGuess, lockCombination);
            }
        }
        
        System.out.println("\n" + partnerName + ": We don't have time for this.");
		System.out.println(partnerName + " kicks the door a couple times and injures their leg.");
		return false;
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