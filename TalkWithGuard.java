import java.util.Random;
import java.util.Scanner;
public class TalkWithGuard {
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
		
		money -= (money * 0.00);
		
		System.out.println(partnerName + ": We're not from here. We got lost.");
		//delaySpeech(2);
		System.out.println("GUARD 1: Ah, well did you see anyone come out here.");
		//delaySpeech(2);
		System.out.println(partnerName + ": Nah, we just got here.");
		//delaySpeech(2);
		System.out.println("The guards look at each other, then look back at you.");
		//delaySpeech(2);
		System.out.println("GUARD 2: Hey so what do you have in those bags.");
		//delaySpeech(2);
		System.out.println("Your partner immediately shoots one of the guards.");
		//delaySpeech(2);
		System.out.println(partnerName + ": RUN!");
		//delaySpeech(2);
		System.out.println(partnerName + ": THERE'S THE CAR!");
		//delaySpeech(3);
        System.out.println("You book it to the backseat. While your partner takes the front seat.");
		System.out.println("Your team successfully escape ");
		
	}
}