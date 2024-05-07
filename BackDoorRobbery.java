import java.util.Scanner;
public class BackDoorRobbery {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		// STATS
		int intellect = 0;
		int strength = 0;
		int sneak = 0;
		int intimidate = 0;
		
		// strings
		String partnerName = "PARTNER";
		String toolName = "TOOL"; 
		
		System.out.println("You are sneaking through the back door with partner");
		//DelaySpeech
		System.out.println("PARTNER: Watch out for the cameras, let me disable them");
		//Game
		System.out.println("PARTNER: we cracked it. we don't " +
						   "have much time, let's go.");
		//DelaySpeech
		System.out.println("Both of you make it to the vault door and your partner unlocks it.");
		//DelaySpeech
		System.out.println("PARTNER: grab some money and let's get out of here.");
		//DelaySpeech
		System.out.println("You think to yourself if \nA. going up the vent \nor \nB. going back up the stairs is better?: ");
		char inputExitChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputExitChoice) == 'A') {
			System.out.println("You chose to go up the vent.");
		} else if (Character.toUpperCase(inputExitChoice) == 'B') {
			System.out.println("You chose to go up the stairs");
		}
		// This would transition to either to vents or stairs decision
	}
}