import java.util.Random;
import java.util.Scanner;
public class ThroughVents {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		// STATS
		int intellect = 0;
		int strength = 0;
		int sneak = 4;
		int intimidate = 0;
		int money = 0;
		
		// strings
		String partnerName = "PARTNER";
		String toolName = "TOOL"; 
		
		money -= (money * 0.02);
		
		System.out.println("You chose to go up the vent.");
		
		
		System.out.println(partnerName + ": alright! shhh.");
		//delaySpeech(2);
        System.out.println(partnerName + ": in here.");
		//delaySpeech(2);
		System.out.println("Your follow " + partnerName +
						  " into the vents.");
		//delaySpeech(2);
		System.out.println(partnerName + ": let's get to the roof.");
		//delaySpeech(2);
		System.out.println("GUARD: HEY! SOMEONE BROKE IN!");
		//delaySpeech(2);
        System.out.println("Your partner's eyes begin to widen.");
		//delaySpeech(2);
		System.out.println(partnerName + " mouths shhhh to quiet you");
		if (toolName == "Noise-Cancellation Boots") {
			System.out.println("Fortunately you have the " + toolName +
							  " so your steps were silent as you crawl through the vents.");
			//delaySpeech(2);
			System.out.println(partnerName + ": c'mon");
			//delaySpeech(2);
			System.out.println("You make it to the roof.");
			//delaySpeech(2);
			System.out.println(partnerName + ": Where do we go now?");
			//delaySpeech(3);
			System.out.println("You can" +
							   "\nA. run up front to jump off the roof into some bushes," 
							   + "\nor \nB. climb down the side.");
			char inputRoofChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputRoofChoice) == 'A') {
				System.out.println("You chose to jump off the front of the building");
			} else if (Character.toUpperCase(inputRoofChoice) == 'B') {
				System.out.println("You chose to climb down the side of the building");
			}
		} else {
			System.out.println("As you walk through the vents, " +
							   "you try your hardest to not make noise");
			if (statCheckCalculator(sneak,0.14)) {
				System.out.println("You succeeded the stat check.");
			} else {
				System.out.println("You failed the stat check.");
				System.out.println("The guards start to shoot at you");
				if (Math.random() < (sneak * 0.14)) {
					System.out.println("You and " + partnerName +
									  "scramble and climb up the ladder.");
					money -= (money * 0.02);
				} else {
					System.out.println("You get shot and died.");
					//delaySpeech(2);
					System.out.println("You lost.");
					money -= (money * 0);
					return money;
				}
			}
		}
		// This would transition to either to jump down in the front or climb down side decision
	}
	public static boolean statCheckCalculator(int multiplier, double percent) {
	double successChance = multiplier * percent; // success is based on the skill multiplier and base chance of working

	System.out.println(successChance);

	double randomNum = Math.random();

	System.out.println(randomNum);

	return (randomNum < successChance); // if the randomNum 0-99 is less than successChance, the skill check passes true
	}
}
