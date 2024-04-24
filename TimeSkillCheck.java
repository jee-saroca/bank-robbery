/*	User will be given a set/given time to count to.
	After the user counts to this time, they will have
	to interact with the keyboard by clicking 'enter'
*/ 
//import java.lang.System;
import java.util.Scanner;
public class TimeSkillCheck {
	public static void main(String[] args) {
		// keeps time at the start of the game
		long start = System.currentTimeMillis();
		System.out.println(start);
		// scanner system that stops the timer
		System.out.print("Press Enter when you want to stop: ");
		Scanner stopTimer = new Scanner(System.in); 
		
		String userInput = stopTimer.nextLine(); // userInput doesn't matter,
		
		if (userInput != null) { // null so if user accidentally inputs text, the timer stops regardless
			long end = System.currentTimeMillis();
			System.out.println("Took : " + (end - start) + " milliseconds");
		}
	}
}