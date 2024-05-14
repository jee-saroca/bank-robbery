import java.util.Random;
import java.util.Scanner;
public class ShootTheGuard {
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
		
		money -= (money * 0.03);
		
		System.out.println("You chose to shoot the guard.");
		
		if (timeSkillCheck()) {
			System.out.println("You successfully shot the guard.");
			System.out.println("You hit one of the guards, but your partner misses");
			//delaySpeech(2);
			System.out.println(partnerName + ": RUN!");
			//delaySpeech(2);
			System.out.println(partnerName + ": THERE'S THE CAR!");
			//delaySpeech(3);
		} else {
			System.out.println("You and " + partnerName + " failed to shoot the guard.");
			//delaySpeech(2);
			System.out.println("The guards shot back");
			//delaySpeech(2);
			System.out.println("You get hit in the shoulder," +
							   " but you manage to get to your car.");
			money -= (money * 0.10);
			//delaySpeech(2);
		}
		System.out.println("You book it to the backseat. " +
						   "While your partner takes the front seat.");
		System.out.println("Your team successfully escape");
		// return money;
		
	}
	public static boolean timeSkillCheck() {
		int randomTime = (int) (1 + Math.random() * (5 - 1 + 1));
		System.out.println("\nCount to " + randomTime + " seconds");
		// keeps time at the start of the game
		long start = System.currentTimeMillis();
		// System.out.println(start); // debug code
		// scanner system that stops the timer
		System.out.print("Press Enter when you want to stop: ");
		Scanner stopTimer = new Scanner(System.in); 
		
		String userInput = stopTimer.nextLine(); // userInput doesn't matter,
		boolean result = false;
		if (userInput != null) { // null so if user accidentally inputs text, the timer stops regardless
			long end = System.currentTimeMillis(); 
			long timeDiff = (end - start); // time it takes to click Enter 
			System.out.println("Took : " + timeDiff + " milliseconds");
			int timeWithin = (int) ((randomTime * 1000) - timeDiff);
			System.out.println("You are within " + Math.abs(timeWithin) + // distance from randomtime
							  " milliseconds of randomTime");
			if (Math.abs(timeWithin) < (0.20 * randomTime * 1000)) { /* if timeWithin is within
			1/5 the time of the given time, the user succeeds */
				System.out.println("You succeeded");
				result = true;
			} else {
				System.out.println("You failed");
				result = false;
			}
		}
		return result;
	}
}
