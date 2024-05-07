import java.util.Random;
import java.util.Scanner;
public class ThroughStairs {
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
		
		System.out.println("PARTNER: Alright! Let's get out of here.");
		//delaySpeech(3);
        System.out.println("Before you take a step outside the vault, your partner stops you");
        System.out.println("PARTNER: Hold it. Let me check something");
		//delaySpeech(3);
        System.out.println("He whips out his tablet.");
		//delaySpeech(3)
        System.out.println("PARTNER: They activated their silent alarm");
		//delaySpeech(3);
        System.out.println("PARTNER: We have to hack in, help me solve it.");
		//delaySpeech(3);
        //stairsOptionGame(intellect skill check for difficulty);
        System.out.println("PARTNER: Nice! Let's get out of here");
		//delaySpeech(3);
        System.out.println("Both of you make it out the back door of the building.");
		//delaySpeech(3);
        System.out.println("Hey what are you two doing here");
		//delaySpeech(2);
        System.out.println("You turn around to see two guards looking at you from the door.");
		//delaySpeech(0.5);
		System.out.println("You quickly have to decide whether you will:"
						  + "\nA. Shoot at them\nB. Talk with them");
		char inputOutsideChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputOutsideChoice) == 'A') {
			System.out.println("You chose to shoot the guard.");
		} else if (Character.toUpperCase(inputOutsideChoice) == 'B') {
			System.out.println("You chose to talk with the guards");
		}
	}
}
					
