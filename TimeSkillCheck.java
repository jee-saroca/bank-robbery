/*	User will be given a set/given time to count to.
	After the user counts to this time, they will have
	to interact with the keyboard by clicking 'enter'
*/ 
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class TimeSkillCheck {
	public static void main(String[] args) {
		int randomTime = (int) (1 + Math.random() * (5 - 1 + 1));
		System.out.println("Count to " + randomTime " seconds");
		// keeps time at the start of the game
		long start = System.currentTimeMillis();
		System.out.println(start);
		// scanner system that stops the timer
		System.out.print("Press Enter when you want to stop: ");
		Scanner stopTimer = new Scanner(System.in); 
		
		String userInput = stopTimer.nextLine(); // userInput doesn't matter,
		
		if (userInput != null) { // null so if user accidentally inputs text, the timer stops regardless
			long end = System.currentTimeMillis(); 
			long timeDiff = (end - start); // time it takes to click Enter 
			System.out.println("Took : " + timeDiff + " milliseconds");
			System.out.println("You are within " + ((randomTime * 1000) - timeDiff) + // distance from randomtime
							  " milliseconds of randomTime");
		}
	}
}
