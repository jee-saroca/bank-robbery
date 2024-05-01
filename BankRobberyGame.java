public class BankRobberyGame {
  public static void main(String[] args) {
    Scanner charReader = new Scanner(System.in);
		
		System.out.println("DRIVER: Hey boss, where will our next score be");
		// DelaySpeech Method
		System.out.println("DRIVER: Oooh that's going to be tough, I think we should some help.");
		// DelaySpeech Method
		System.out.println("DRIVER: So who should we get?");
		// DelaySpeech Method
		
		System.out.println("Type the letter of which partner you want to bring\nA. Nerd\n" +
						  "B. Brute\nC. Sly\nD. Menace");
		
		
		char inputPartnerChoice = charReader.next().charAt(0);
		System.out.println("You chose " + inputPartnerChoice);
		charReader.close(); // not necessary for this project bc it's so small, but good practice
    
  }
}
