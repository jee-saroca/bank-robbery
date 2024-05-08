import java.util.Random;
import java.util.Scanner;
public class BreakThroughDoor {
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
		
		System.out.println("You chose to break through the door");
		
		
		System.out.println("You kick the door open and heads towards the Bank Teller pointing his gun at him.");
		//delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
		//delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
		//delaySpeech(2);
		System.out.println("The teller points to the back");
		//delaySpeech(2);
        System.out.println("PLAYER: OPEN THE DOOR NOW!!!!!");
		//delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not here.");
		//delaySpeech(2);
        System.out.println("PLAYER: DAMN!!!! OK LET'S SEE IF I COULD LOCK PICK THIS THEN!!!!");
		//delaySpeech(2);
    	//Lock Pick Skilled Check
        System.out.println("PLAYER: Ok, let's get a move on buddy.");
		//delaySpeech(2);
    	System.out.println("PLAYER and the Bank Teller head towards the vault.");
		//delaySpeech(2);
        System.out.println("PLAYER: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
		//delaySpeech(2);
        System.out.println("Bank Teller: Is, 6-4-2. That's the code for the vault.");
		//delaySpeech(2);
		System.out.println("TELLER: Ok, there it's open.");
		//delaySpeech(2);
        System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
		//delaySpeech(3);
    	System.out.println("You takes out his bag and collect money from the vault.");
		//delaySpeech(3);
		money += 175000;
        System.out.println("YOU: OK, Got the dough. Lets go.");
		//delaySpeech(3);
        System.out.println(partnerName + ": Got it. Let's go to the back door.");
		//delaySpeech(2);
        System.out.println("YOU: Ok, meet you there.");
		System.out.println("You meet up with " + partnerName +
						  " and escape to the car.");
	}
}
