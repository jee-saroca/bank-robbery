import java.util.Scanner;
public class ThroughVents {
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
		
		money -= (money * 0.10);
		
		System.out.println("You chose to jump off the front of the building");
		
		System.out.println("You notify your getaway driver.");
		delaySpeech(2);
		System.out.println(partnerName + ": Alright then, here we go.");
		delaySpeech(2);
		System.out.println("Both of you guys jump off and land in the bushes.");
		delaySpeech(2);
		System.out.println(partnerName +": AHHH");
		delaySpeech(2);
		System.out.println(partnerName + "I think I injured my leg.");
		delaySpeech(2);
		System.out.println("You help your partner into the front seat of the car.");
		delaySpeech(2);
		System.out.println("As you do so, you hear:");
		delaySpeech(2);
		System.out.println("HEY STOP RIGHT THERE!");
		delaySpeech(2);
		System.out.println("You climb into the car, and escape by a hair.");
		delaySpeech(2);
	}
}