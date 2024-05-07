import java.util.Random;
import java.util.Scanner;
public class ClimbDownSide {
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
		
		System.out.println("You chose to climb down the side of the building");
		//delaySpeech(2)
		System.out.println("You notify your getaway driver.");
		//delaySpeech(2)
        System.out.println(partnerName + ": I'm going to climb down.");
		//delaySpeech(2)
        System.out.println("You follow your partner and successfully escape when" +
						   "\nyou hear police sirens in the distance.");
	}
}