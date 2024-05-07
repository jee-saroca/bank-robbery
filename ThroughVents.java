import java.util.Scanner;
public class BackDoorRobbery {
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
		
		money -= (money * 0.01);
		
		System.out.println("You chose to go up the vent.");
		
		
		System.out.println("PARTNER: alright! shhh.");
		//delaySpeech(2);
        System.out.println("PARTNER: in here.");
        //skillCheckCalculator(sneak,0.20)
		
		System.out.println("PARTNER: let's get to the roof.");
		//delaySpeech(2);
        System.out.println("Before you guys make it to the roof, you hear");
		//delaySpeech(2);
        System.out.println("GUARD: HEY! SOMEONE BROKE IN!");
		//delaySpeech(2);
        System.out.println("Your partner's eyes begin to widen.");
		//delaySpeech(2);
        System.out.println("PARTNER: c'mon");
		//delaySpeech(2);
        System.out.println("You make it to the roof.");
		//delaySpeech(2);
        System.out.println("PARTNER: Where do we go now?");
		//delaySpeech(3);
		System.out.println("You can run up front to jump off the roof into some bushes, or climb down the side.");
		char inputEntranceChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputEntranceChoice) == 'A') {
			System.out.println("You chose to jump off the front of the building");
		} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
			System.out.println("You chose to climb down the side of the building");
		}
		// This would transition to either to jump down in the front or climb down side decision
	}
}
