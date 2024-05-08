import java.util.Scanner;
public class BankRobberyGame {
	public static void main(String[] args) {
		// STATS
		int intellect = 0;
		int strength = 0;
		int sneak = 0;
		int intimidate = 0;
		Scanner charReader = new Scanner(System.in);
		
		// INTRODUCTION
		System.out.println("DRIVER: Hey boss, where will our next score be?");
		delaySpeech(2); // delay is 2 seconds
		System.out.println("DRIVER: Bank of Chase Fargo?");
		delaySpeech(2);
		System.out.println("DRIVER: Oooh that's going to be tough, I think we should get some help.");
		delaySpeech((long)2.3);
		System.out.println("DRIVER: So who should we get?");
		delaySpeech(2);
		
		// PARTNER CHOICE
		System.out.println("Type the letter of which partner you want to bring\nA. Nerd\n" +
						  "B. Brute\nC. Sly\nD. Menace");
		
		String partnerName;
		
		char inputPartnerChoice = charReader.next().charAt(0);
		
		switch(Character.toUpperCase(inputPartnerChoice)) {
			case 'A':
				partnerName = "Nerd"; 
				intellect += 4;
				sneak += 2;
				strength += 1;
				break;
			case 'B':
				partnerName = "Brute"; 
				strength += 4;
				intimidate += 2;
				sneak += 1;
				break;
			case 'C':
				partnerName = "Sly"; 
				sneak += 4;
				intellect += 2;
				intimidate += 1;
				break;
			case 'D':
				partnerName = "Menace"; 
				intimidate += 4;
				strength += 2;
				intellect += 1;
				break;
			default:
				partnerName = "Nerd"; 
				intellect += 4;
				sneak += 2;
				strength += 1;
				System.out.println("You didn't choose a possible option, so you're stuck with the Nerd.");
		}
		delaySpeech(1);
		System.out.println("DRIVER: Really? You chose the... " + partnerName + "?");
		delaySpeech(2);
		System.out.println("DRIVER: ... Alright then, what tool do we need?");
		// TOOL CHOICE
		System.out.println("Type the letter of which tool you want to bring\nA. Doohickey USB\n" +
						  "B. Steroids\nC. Noise-Cancellation Boots\nD. Bigger Gun");
		
		String toolName;
		
		char inputToolChoice = charReader.next().charAt(0);
		
		switch(Character.toUpperCase(inputToolChoice)) {
			case 'A':
				toolName = "Doohickey USB"; 
				intellect += 2; break;
			case 'B':
				toolName = "Steroids"; 
				strength += 2; break;
			case 'C':
				toolName = "Noise-Cancellation Boots"; 
				sneak += 2; break;
			case 'D':
				toolName = "Bigger Gun"; 
				intimidate += 2; break;
			default:
				toolName = "Steroids";
				strength += 2;
				System.out.println("You didn't choose a possible option, so you're stuck with Steroids.");
		}
		
		System.out.println("DRIVER: Nice choice, the " + toolName + " will be useful.");

		System.out.println("intelligence is " + intellect); // debug code
		System.out.println("Strength is " + strength); // debug code
		System.out.println("sneak is " + sneak); // debug code
		System.out.println("intimidate is " + intimidate); // debug code

		System.out.println("Your driver takes you to the bank.");
		delaySpeech(3);
		System.out.println("You stake out the place to look for an opening.");
		delaySpeech(4);
		System.out.println("You think in your head that you can enter through " 
						   + "the:\nA. Front Door\nB. Back Door");
		char inputEntranceChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputEntranceChoice) == 'A') {
			FrontDoorRobbery(partnerName, toolName);
		} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
			System.out.println("You chose to go through the Back Door");
		}
		charReader.close(); // not necessary for this project bc it's so small, but good practice
	}
	
	public static void delaySpeech(long duration) { // This needs to long
		try {
			Thread.sleep(duration * 1000); // sleep uses milliseconds, so converts seconds to milli-
		}
		catch (Exception e) { // need this or else it causes errors
			System.out.println(e);
		}
	}
	public static boolean StatCheckCalculator(int multiplier, double percent) {
		double successChance = multiplier * percent; // success is based on the skill multiplier and base chance of working
		
		System.out.println(successChance);
		
		double randomNum = Math.random();
		
		System.out.println(randomNum);
		
		return (randomNum < successChance); // if the randomNum 0-99 is less than successChance, the skill check passes true
	}
	public static void FrontDoorRobbery(String partnerName, String toolName) {
		Scanner charReader = new Scanner(System.in);
		System.out.println("You chose to go through the Front Door");
		delaySpeech(4);
		System.out.println(partnerName + ": This is it, let's go!");
		delaySpeech(4);
		System.out.println("You bust through the door with " + partnerName);
		delaySpeech((long)0.25);
		System.out.println("What do you say?:\nA. EVERYONE PUT YOUR HANDS UP\nB. "
						  + "EVERYONE PUT YOUR HANDS DOWN\nC. GET ON THE GROUND");
		char inputEntranceChoice = '~';
		
		while (Character.toUpperCase(inputEntranceChoice) != 'A' ||
			  Character.toUpperCase(inputEntranceChoice) != 'B' ||
			  Character.toUpperCase(inputEntranceChoice) != 'C' ) {
			inputEntranceChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputEntranceChoice) == 'A') {
				System.out.println("YOU: EVERYONE PUT YOUR HANDS UP");
				delaySpeech((long)1.5);
				System.out.println(partnerName + ": GET ON THE GROUND NOW");
				break;
			} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
				System.out.println("YOU: EVERYONE PUT YOUR HANDS DOWN");
				delaySpeech((long)1.5);
				System.out.println(partnerName + " looks at you weirded out.");
				System.out.println(partnerName + "EVERYONE PUT YOUR HANDS UP!");
				break;
			} else if (Character.toUpperCase(inputEntranceChoice) == 'C') {
				System.out.println("YOU: GET ON THE GROUND");
				delaySpeech((long)1.5);
				System.out.println(partnerName + ": EVERYONE PUT YOUR HANDS UP");
				break;
			}
			System.out.println("That isn't A, B, or C");
		}
		System.out.println(partnerName + ": THIS IS A ROBBERY");
		//delaySpeech(0.1)
    	//SkillCheckCalculator(intimidate,0.20);
    	System.out.println("Both of you go to the teller, pointing your guns.");
		System.out.println("Do you: \nA. Yell at bank teller\nB. Break through door");
		char inputTellerChoice = '~';
		while (Character.toUpperCase(inputTellerChoice) != 'A' ||
			  Character.toUpperCase(inputTellerChoice) != 'B') {
			inputTellerChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputTellerChoice) == 'A') {
				System.out.println("You chose to yell at the bank teller.");
				break;
			} else if (Character.toUpperCase(inputTellerChoice) == 'B') {
				System.out.println("You chose to break through the door");  
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}
	}
}
