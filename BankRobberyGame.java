import java.util.Scanner;
public class BankRobberyGame {
	public static void main(String[] args) {
		Scanner charReader = new Scanner(System.in);
		
		// INTRODUCTION
		System.out.println("DRIVER: Hey boss, where will our next score be?");
		delaySpeech(2); // delay is 2 seconds
		System.out.println("DRIVER: Bank of Chase Fargo? Oooh that's going to be tough, I think we should some help.");
		delaySpeech(3);
		System.out.println("DRIVER: So who should we get?");
		delaySpeech(2);
		
		// PARTNER CHOICE
		System.out.println("Type the letter of which partner you want to bring\nA. Nerd\n" +
						  "B. Brute\nC. Sly\nD. Menace");
		
		String partnerName;
		
		char inputPartnerChoice = charReader.next().charAt(0);
		
		switch(Character.toUpperCase(inputPartnerChoice)) {
			case 'A':
				partnerName = "Nerd"; break;
			case 'B':
				partnerName = "Brute"; break;
			case 'C':
				partnerName = "Sly"; break;
			case 'D':
				partnerName = "Menace"; break;
			default:
				partnerName = "Error, this should never happen";
		}
		delaySpeech(1);
		System.out.println("DRIVER: Really? You chose the... " + partnerName + "?");
		delaySpeech(2);
		
		// TOOL CHOICE
		System.out.println("Type the letter of which partner you want to bring\nA. Doohickey USB\n" +
						  "B. Steroids\nC. Noise-Cancellation Boots\nD. Bigger Gun");
		
		String toolName;
		
		char inputToolChoice = charReader.next().charAt(0);
		
		switch(Character.toUpperCase(inputToolChoice)) {
			case 'A':
				toolName = "Doohickey USB"; break;
			case 'B':
				toolName = "Steroids"; break;
			case 'C':
				toolName = "Noise-Cancellation Boots"; break;
			case 'D':
				toolName = "Bigger Gun"; break;
			default:
				toolName = "Error, this should never happen";
		}
		
		System.out.println("DRIVER: Nice choice, the " + toolName + " will be useful.");
		charReader.close(); // not necessary for this project bc it's so small, but good practice
	}
	
	public static void delaySpeech(int duration) { // This needs to return int
		try {
			Thread.sleep(duration * 1000); // sleep uses milliseconds, so converts seconds to milli-
		}
		catch (Exception e) { // need this or else it causes errors
			System.out.println(e);
		}
	}
}
