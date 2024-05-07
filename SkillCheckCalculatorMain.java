import java.util.Random;
import java.util.Scanner;
public class SkillCheckCalculatorMain {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		// STATS
		int intellect = 3;
		int strength = 0;
		int sneak = 0;
		int intimidate = 0;
		
		// strings
		String partnerName = "PARTNER";
		String toolName = "TOOL"; 
		boolean answer = SkillCheckCalculator(intellect,0.15);
		System.out.println(answer);
	}
	public static boolean SkillCheckCalculator(int multiplier, double percent) {
		double successChance = multiplier * percent;
		
		System.out.println(successChance);
		
		double randomNum = Math.random();
		
		System.out.println(randomNum);
		
		return (randomNum > successChance);
	}
}