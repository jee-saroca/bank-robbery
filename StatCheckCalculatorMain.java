import java.util.Random;
import java.util.Scanner;
public class StatCheckCalculatorMain {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		// STATS
		int intellect = 3;
		int strength = 0;
		int sneak = 0;
		int intimidate = 0;
		int money = 0;
		
		// strings
		String partnerName = "PARTNER";
		String toolName = "TOOL"; 
		boolean answer = StatCheckCalculator(intellect,0.20);
		System.out.println(answer);
	}
	public static boolean StatCheckCalculator(int multiplier, double percent) {
		double successChance = multiplier * percent; // success is based on the skill multiplier and base chance of working
		
		System.out.println(successChance);
		
		double randomNum = Math.random();
		
		System.out.println(randomNum);
		
		return (randomNum < successChance); // if the randomNum 0-99 is less than successChance, the skill check passes true
	}
}
