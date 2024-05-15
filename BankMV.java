// Add help -help mode stuff. Every story part method should include displayhelp() integration
// Fixed - Error when you get to stairOptionGame having nerd and usb wont do anything.


import java.util.Scanner;
public class BankMV {
    // This constant tells us when the prgram started.
    public static final long programStart = System.currentTimeMillis();
    
    public static void main(String[] args) {
        
        // STATS
		int intellect = 1;
		int strength = 1;
		int sneak = 1;
		int intimidate = 1;
		double money = 0;
		
        Scanner charReader = new Scanner(System.in);
        
        // Game Start: Tells you what mode you have selected
        if(args.length != 0 && args[0].equals("-help")) {
            displayHelp();
            boolean helpMode = true;
        } else {
            delaySpeech(500);
            slowType("\n\fYou have Selected \"Normal Mode\" ", 115);
            delaySpeech(2500);
        }
        
        // Prelude Method Plays
        prelude(charReader);
        
		// INTRODUCTION
        delaySpeech(2000);
		System.out.println("DRIVER: Hey boss, where will our next score be?");
		delaySpeech(2000); // delay is 2 seconds
		System.out.println("DRIVER: Bank of Chase Fargo?");
		delaySpeech(1500);
		System.out.println("DRIVER: Oooh that's going to be tough, I think we should get some help.");
		delaySpeech(2000);
		System.out.println("DRIVER: So who should we get?");
		delaySpeech(1000);
		
		// PARTNER CHOICE Method here: User picks a partner, gets stored in var partner
        String partnerName = partnerChoice(charReader, intellect, strength, sneak, intimidate);
        System.out.println("\nChosen Partner: " + partnerName + "\n");
        
        
        // Tool Choice
        delaySpeech(2);
		System.out.println("DRIVER: ... Alright then, what tool do we need?");
        String toolName = toolChoice(charReader, intellect, strength, sneak, intimidate);
        System.out.println("\nChosen Tool: " + toolName);
      
        
        // Bank entrance Option: Front or Back
        delaySpeech(2);
		System.out.println("\nYour driver takes you to the bank.");
		delaySpeech(3);
		System.out.println("You stake out the place to look for an opening.");
		delaySpeech(4);
		System.out.println("You think in your head that you can enter through " 
						   + "the:\nA. Front Door\nB. Back Door");
		char inputEntranceChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputEntranceChoice) == 'A') {
            money = frontDoorRobbery(charReader, partnerName, toolName, money, intellect, strength, 
                                     sneak, intimidate);
		} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
			money = backDoorRobbery(charReader, partnerName, toolName, money, intellect, strength,
                                    sneak, intimidate);
		} else {
			System.out.println("You didn't choose a viable option, so you are" +
							   " taking the front entrance.");
			money = frontDoorRobbery(charReader, partnerName, toolName, money, intellect, strength,
                                     sneak, intimidate);
		}
		charReader.close(); // not necessary for this project bc it's so small, but good practice
		
		System.out.println("YOU STOLE $" + (int) money + "!\n");
        delaySpeech(500);
        gameTime();
		if (money > 0)
		  System.out.println("CONGRATS!");
        
    }
    
    // Method for the front door robbery
    public static double frontDoorRobbery(Scanner charReader, String partnerName, String toolName,                                                   double money, int intellect, int strength, 
                                          int sneak, int intimidate) {
        System.out.println("\nYou chose to go through the Front Door.\n");
        delaySpeech(3);
        System.out.println(partnerName + ": This is it, let's go!");
        delaySpeech(3);
        System.out.println("You bust through the door with " + partnerName);
        delaySpeech((long)0.25);
        System.out.println("What do you say?:\nA. EVERYONE PUT YOUR HANDS UP\nB. "
                            + "EVERYONE PUT YOUR HANDS DOWN\nC. GET ON THE GROUND");
        char inputEntranceChoice = '~';
    
        while (Character.toUpperCase(inputEntranceChoice) != 'A' ||
               Character.toUpperCase(inputEntranceChoice) != 'B' ||
               Character.toUpperCase(inputEntranceChoice) != 'C' ) {
            inputEntranceChoice = charReader.next().charAt(0);
            if (Character.toUpperCase(inputEntranceChoice) == 'A') {
                System.out.println("YOU: EVERYONE PUT YOUR HANDS UP");
                delaySpeech((long)1.5);
                System.out.println(partnerName + ": GET ON THE GROUND NOW");
            break;
            } else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
                System.out.println("YOU: EVERYONE PUT YOUR HANDS DOWN");
                delaySpeech((long)1.5);
                intimidate -= 1;
                System.out.println(partnerName + " looks at you weirded out.");
                System.out.println(partnerName + "EVERYONE PUT YOUR HANDS UP!");
                break;
            } else if (Character.toUpperCase(inputEntranceChoice) == 'C') {
                System.out.println("YOU: GET ON THE GROUND");
                delaySpeech((long)1.5);
                System.out.println(partnerName + ": EVERYONE PUT YOUR HANDS UP");
                break;
            }
            System.out.println("That isn't A, B, or C");
        }
        System.out.println(partnerName + ": THIS IS A ROBBERY");
        delaySpeech((long)0.1);
        if (statCheckCalculator(intimidate, 0.20)) {
            money += 25000;
            System.out.println("Successfully Intimidated.\n");
        }
        System.out.println("Both of you go to the teller, pointing your guns.");
        System.out.println("Do you: \nA. Yell at bank teller\nB. Break through door");
        char inputTellerChoice = '~';
        while (Character.toUpperCase(inputTellerChoice) != 'A' ||
               Character.toUpperCase(inputTellerChoice) != 'B') {
            inputTellerChoice = charReader.next().charAt(0);
            if (Character.toUpperCase(inputTellerChoice) == 'A') {
                money = yellAtTeller(charReader, partnerName, toolName, money, intellect, strength, sneak, intimidate);
                break;
            } else if (Character.toUpperCase(inputTellerChoice) == 'B') {
               money = breakThroughDoor(charReader, partnerName, toolName, money, intellect, strength,                            sneak, intimidate);
                break;
            } else {
                System.out.println("That isn't A or B");
            }
        }
        return money;
    }
    
    // Method for yellAtTeller Option: Gets called on during front door option
    public static double yellAtTeller(Scanner charReader, String partnerName, String toolName, double                                     money,int intellect, int strength, int sneak, int intimidate) {
        System.out.println("\nYou chose to yell at the bank teller.\n");
    
        System.out.println("You kick the door open and heads towards the Bank Teller pointing his gun at                           him.");
        delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
        delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
        delaySpeech(2);
        System.out.println("The teller points to the back");
        delaySpeech(2);
        System.out.println("PLAYER: OPEN THE DOOR NOW!!!!!");
        delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not                             here.");
        delaySpeech(2);
        System.out.println("PLAYER: DAMN!!!! OK LET'S SEE IF I COULD LOCK PICK THIS THEN!!!!");
        delaySpeech(2);
    
        boolean resultOfLockPick = lockPickMini(charReader, partnerName);
    
        if(resultOfLockPick) {
            System.out.println("YOU: Ok, let's get a move on buddy.");
            delaySpeech(2);
            System.out.println("The Bank Teller takes you to the vault.");
            delaySpeech(2);
            System.out.println("YOU: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
            delaySpeech(2);
            System.out.println("Bank Teller: It's, 6-4-2. That's the code for the vault.");
            delaySpeech(2);
            System.out.println("Bank Teller: Ok, there it's open.");
            delaySpeech(2);
            System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
            delaySpeech(3);
            System.out.println("You take out your bag and collect money from the vault.");
            delaySpeech(3);
            money += 190000;
            System.out.println("YOU: OK, Got the dough. Lets go.");
            delaySpeech(3);
            System.out.println(partnerName + ": Got it. Let's go to the back door.");
        } else {
            System.out.println("YOU: Ok, let's get a move on buddy.");
            delaySpeech(2);
            System.out.println("The Bank Teller takes you to the vault.");
            delaySpeech(2);
            System.out.println("YOU: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
            delaySpeech(2);
            System.out.println("Bank Teller: It's, 6-4-2. That's the code for the vault.");
            delaySpeech(2);
            System.out.println("Bank Teller: Ok, there it's open.");
            delaySpeech(2);
            System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
            delaySpeech(3);
            System.out.println("You takes out his bag and collects money from the vault.");
            delaySpeech(3);
            money += 155000;
            System.out.println("YOU: OK, Got the dough. Lets go.");
            delaySpeech(3);
            System.out.println(partnerName + ": Got it. Let's go to the back door.");
        }
    
        delaySpeech(2);
        System.out.println("YOU: Ok, meet you there.");
        System.out.println("You meet up with " + partnerName +
                        " and escape to the car.");
        return money;
    }
    
    // Method for breakThroughDoor option: called in front door option
    public static double breakThroughDoor(Scanner charReader, String partnerName, String toolName,                                              double money, int intellect, int strength, int sneak, 
                                           int intimidate) {
        System.out.println("\nYou chose to break through the door.\n");
    
        System.out.println("You kick the door open and heads towards the Bank Teller pointing his gun at                    him.");
        delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
        delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
        delaySpeech(2);
        System.out.println("The teller points to the back");
        delaySpeech(2);
        System.out.println("PLAYER: OPEN THE DOOR NOW!!!!!");
        delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not                       here.");
        delaySpeech(2);
        System.out.println("PLAYER: Ok, let's get a move on buddy.");
        delaySpeech(2);
        System.out.println("PLAYER and the Bank Teller head towards the vault.");
        delaySpeech(2);
        System.out.println("PLAYER: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
        delaySpeech(2);
        System.out.println("Bank Teller: Is, 6-4-2. That's the code for the vault.");
        delaySpeech(2);
        System.out.println("TELLER: Ok, there it's there it's open.");
        delaySpeech(2);
        System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
        delaySpeech(3);
        System.out.println("You takes out his bag and collect money from the vault.");
        delaySpeech(3);
        money += 175000;
        System.out.println("YOU: OK, Got the dough. Lets go.");
        delaySpeech(3);
        System.out.println(partnerName + ": Got it. Let's go to the back door.");
        delaySpeech(2);
        System.out.println("YOU: Ok, meet you there.");
        System.out.println("You meet up with " + partnerName 
                           + " and escape to the car.");
        return money;
    }
    
    // Method for the Back door approach
    public static double backDoorRobbery(Scanner charReader, String partnerName, String toolName, double                                            money, int intellect, int strength, int sneak, int intimidate) {
        System.out.println("\nYou are sneaking through the back door with partner.\n");
    
        delaySpeech(3);
        System.out.println(partnerName + ": Watch out for the cameras, let me disable them");
        delaySpeech(1);
        slowType("...",500);
        System.out.println(partnerName + ": We cracked it. we don't " +
                           "have much time, let's go.");
        delaySpeech(3);
        System.out.println("Both of you make it to the vault door and your partner unlocks it.");
        delaySpeech(3);
        System.out.println(partnerName + ": Grab some money and let's get out of here.");
        delaySpeech(3);
        money += 200000;
        System.out.println("You think to yourself if \nA. going up the vent \nOr \nB. going back up the"                           + " stairs\nis better?: ");
    
        char inputExitChoice = '~';
        while (Character.toUpperCase(inputExitChoice) != 'A' ||
            Character.toUpperCase(inputExitChoice) != 'B') {
            inputExitChoice = charReader.next().charAt(0);
            if (Character.toUpperCase(inputExitChoice) == 'A') {
                money = throughVents(charReader, partnerName, toolName, money, intellect, strength,
                                     sneak, intimidate);
                break;
            } else if (Character.toUpperCase(inputExitChoice) == 'B') {
                money = throughStairs(charReader, partnerName, toolName, money, intellect, strength,
                                      sneak, intimidate);
                break;
            } else {
                System.out.println("That isn't A or B");
            }
        }
        return money;
    }

    // Method for vent option
    public static double throughVents(Scanner charReader, String partnerName, String toolName, double money,
                                      int intellect, int strength, int sneak, int intimidate) {
        money -= (money * 0.02);
    
        System.out.println("\nYou chose to go up the vent.\n");
    
        System.out.println(partnerName + ": alright. shhh.");
        delaySpeech(2);
        System.out.println(partnerName + ": in here.");
    
        if(statCheckCalculator(sneak, 0.20)) {
            System.out.println("You successfully sneaked.");
        } else {
            System.out.println("You failed to sneak.");
            money -= (money * 0.03);
        }
    
        System.out.println("PARTNER: let's get to the roof.");
        delaySpeech(2);
        System.out.println("Before you guys make it to the roof, you hear");
        delaySpeech(2);
        System.out.println("GUARD: HEY! SOMEONE BROKE IN!");
        delaySpeech(2);
        System.out.println("Your partner's eyes begin to widen.");
        delaySpeech(2);
        System.out.println("PARTNER: c'mon");
        delaySpeech(2);
        System.out.println("You make it to the roof.");
        delaySpeech(2);
        System.out.println("PARTNER: Where do we go now?");
        delaySpeech(3);
        System.out.println("You can:\nA. run up front to jump off the roof into some bushes \nor \nB. climb                       down the side.");
    
        char inputRoofChoice = '~';
        while (Character.toUpperCase(inputRoofChoice) != 'A' ||
               Character.toUpperCase(inputRoofChoice) != 'B') {
               inputRoofChoice = charReader.next().charAt(0);
                if (Character.toUpperCase(inputRoofChoice) == 'A') {
                    money = jumpFrontDown(charReader, partnerName, toolName, money, intellect, 
                                          strength, sneak, intimidate);
                    break;
                } else if (Character.toUpperCase(inputRoofChoice) == 'B') {
                    money = climbDownSide(charReader, partnerName, toolName, money, intellect, strength, 
                                          sneak, intimidate);
                    break;
                } else {
                    System.out.println("That isn't A or B");
                }
        }

        return money;
    }
    
    // jump method
    public static double jumpFrontDown(Scanner charReader, String partnerName, String toolName, double money,
                                    int intellect, int strength, int sneak, int intimidate) {
        money -= (money * 0.10);
    
        System.out.println("\nYou chose to jump off the front of the building.\n");
    
        System.out.println("You notify your getaway driver.");
        delaySpeech(2);
        System.out.println(partnerName + ": Alright then, here we go.");
        delaySpeech(2);
        System.out.println("Both of you guys jump off and land in the bushes.");
        delaySpeech(2);
        System.out.println(partnerName +": AHHH");
        slowType("...", 150);
        delaySpeech(3);
        System.out.println(partnerName + ": I think I injured my leg.");
        delaySpeech(2);
        System.out.println("You help your partner into the front seat of the car.");
        delaySpeech(2);
        System.out.println("As you do so, you hear:");
        delaySpeech(2);
        System.out.println("HEY STOP RIGHT THERE!");
        delaySpeech(2);
        System.out.println("You climb into the car, and escape by a hair.");
        delaySpeech(2);
    
        return money;
    }

    public static double climbDownSide(Scanner charReader, String partnerName, String toolName, double money,
                                       int intellect, int strength, int sneak, int intimidate) {
        money -= 0;
        System.out.println("\nYou chose to climb down the side of the building.\n");
        delaySpeech(2);
        System.out.println("You notify your getaway driver.");
        delaySpeech(2);
        System.out.println(partnerName + ": I'm going to climb down.");
        delaySpeech(2);
        System.out.println("You follow your partner and successfully escape when" +
                           "\nyou hear police sirens in the distance.");
    
        return money;
    }

    // method for using the stairs option
    public static double throughStairs(Scanner charReader, String partnerName, String toolName, double money,
                                       int intellect, int strength, int sneak, int intimidate) {
		
		System.out.println("\nYou chose to go up the stairs.\n");
		
		money -= (money * 0);
		
		System.out.println(partnerName + ": Alright! Let's get out of here.");
		delaySpeech(3);
        System.out.println("Before you take a step outside the vault, your partner stops you");
        System.out.println(partnerName + ": Hold it. Let me check something");
		delaySpeech(3);
        System.out.println("He whips out his tablet.");
		delaySpeech(3);
        System.out.println(partnerName + ": They activated their silent alarm");
		delaySpeech(3);
        System.out.println(partnerName + ": We have to hack in, help me solve it.");
		delaySpeech(3);
		money = stairsOptionGame(charReader, partnerName, toolName, money, intellect, 
                                 strength, sneak, intimidate);
		System.out.println(partnerName + ": Alright. Let's get out of here");
		delaySpeech(3);
		System.out.println("Both of you make it out the back door of the building.");
		delaySpeech(3);
		System.out.println("Hey what are you two doing here");
		delaySpeech(2);
		System.out.println("You turn around to see two guards looking at you from the door.");
		delaySpeech((long)0.5);
		System.out.println("You quickly have to decide whether you will:"
						  + "\nA. Shoot at them\nB. Talk with them");
		
		char inputOutsideChoice = '~';
		while (Character.toUpperCase(inputOutsideChoice) != 'A' ||
			  Character.toUpperCase(inputOutsideChoice) != 'B') {
			inputOutsideChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputOutsideChoice) == 'A') {
				money = shootTheGuard(charReader, partnerName, toolName, money, intellect, strength, 
                                      sneak, intimidate);
				break;
			} else if (Character.toUpperCase(inputOutsideChoice) == 'B') {
				money = talkWithGuard(charReader, partnerName, toolName, money, intellect, strength, 
                                      sneak, intimidate);
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}
		
		return money;
	}
    
    // method to shoot guard
    public static double shootTheGuard(Scanner charReader, String partnerName, String toolName, double money,
                                       int intellect, int strength, int sneak, int intimidate) {
		
		money -= (money * 0.03);
		
		System.out.println("\nYou chose to shoot the guard.\n");
	
        System.out.println("You hit one of the guards, but your partner misses");
		delaySpeech(100);
        System.out.println(partnerName + ": RUN!");
		delaySpeech(200);
		System.out.println(partnerName + ": THERE'S THE CAR!");
		delaySpeech(100);
        System.out.println("You book it to the backseat. While your partner takes the front seat.");
		System.out.println("Your team successfully escape ");
		
		return money;
	}
    
    // Talking with guard method
    public static double talkWithGuard(Scanner charReader, String partnerName, String toolName, double money,
                                       int intellect, int strength, int sneak, int intimidate) {
		
		money -= (money * 0.00);
		
		System.out.println("\nYou chose to talk with the guard.\n");
		
		System.out.println(partnerName + ": We're not from here. We got lost.");
		delaySpeech(2);
		System.out.println("GUARD 1: Ah, well did you see anyone come out here.");
		delaySpeech(2);
		System.out.println(partnerName + ": Nah, we just got here.");
		delaySpeech(2);
		System.out.println("The guards look at each other, then look back at you.");
		delaySpeech(2);
		System.out.println("GUARD 2: Hey so what do you have in those bags.");
		delaySpeech(2);
		System.out.println("Your partner immediately shoots one of the guards.");
		delaySpeech(2);
		System.out.println(partnerName + ": RUN!");
		delaySpeech(2);
		System.out.println(partnerName + ": THERE'S THE CAR!");
		delaySpeech(3);
        System.out.println("You book it to the backseat. While your partner takes the front seat.");
		delaySpeech(3);
		System.out.println("Your team successfully escape");
		return money;
	}
    
    // Method for lockpick game
    public static boolean lockPickMini(Scanner charReader, String partnerName) {
        int[] lockCombination = generateCombination();
        
        System.out.println("Hurry up and pick the lock");
        System.out.println("You need to pick the lock by correctly setting the pins.");
        System.out.println("The lock has 4 pins. Each pin's value ranges from 0 to 9.");
        System.out.println("Enter your guess for each pin and try to unlock the door!");
        
		// number of tries 
        for (int attempts = 1; attempts <= 5; attempts++) {
            System.out.println("\nAttempt " + attempts + ":");
            int[] playerGuess = getPlayerGuess(charReader);
            
            if (checkCombination(playerGuess, lockCombination)) {
                System.out.println("The door is unlocked.");
                return true;
            } else {
                displayFeedback(playerGuess, lockCombination);
            }
        }
        
        System.out.println("\n" + partnerName + ": We don't have time for this.");
		System.out.println(partnerName + " kicks the door a couple times and injures their leg.");
		return false;
    }
    
    // Sets the random numbers 
    public static int[] generateCombination() {
        int[] combination = new int[4];
        for (int i = 0; i < 4; i++) {
            combination[i] = (int) (Math.random() * 10);
        }
        return combination;
    }
    
    // get the player's guess for the lock combination
    public static int[] getPlayerGuess(Scanner charReader) {
        int[] guess = new int[4];
        System.out.print("Enter your guess (4 numbers separated by spaces): ");
        for (int i = 0; i < 4; i++) {
            guess[i] = charReader.nextInt();
        }
        return guess;
    }
    
    // checks combination if correct or false
    public static boolean checkCombination(int[] guess, int[] combination) {
        for (int i = 0; i < 4; i++) {
            if (guess[i] != combination[i]) {
                return false;
            }
        }
        return true;
    }
    
    // This can be used as easy mode though not sure
    public static void displayFeedback(int[] guess, int[] combination) {
        System.out.print("Feedback: ");
        for (int i = 0; i < 4; i++) {
            if (guess[i] == combination[i]) {
                System.out.print("Correct ");
            } else if (guess[i] < combination[i]) {
                System.out.print("Higher ");
            } else {
                System.out.print("Lower ");
            }
        }
        System.out.println();
    }
    
    public static double stairsOptionGame(Scanner charReader, String partnerName, String toolName, double                                         money, int intellect, int strength, int sneak, int intimidate){
		slowType("Initializing...\nNODUS", 150);
        
        // Array holding strings for hang-man type game.
        String[] gameWords = {"Laundrette", "Flukas", "Dreams", "Thief",
                              "Autumn", "Afternoon", "Human", "Condition",
                              "Loser", "Game", "Cat", "Computer", "Liang",
                              "Chips", "Seven", "Granola"};
        
        boolean gameInProgress = true;
        String randomWord;
        int addedTries = 0;
        
        // Gameloop: Code for HangMan Like game.
        while (gameInProgress) {
            randomWord = gameWords[(int) (Math.random() * gameWords.length)];
            String wordHidden = "";
            int wordLength = randomWord.length();

            // Makes the random word picked from array into all *
            for (int i = 0; i < randomWord.length(); i++) {
                wordHidden += "*";
            }

            System.out.println(wordHidden);
            
            // Difficulty adjustment if user has high intellect stats
            if (toolName.equals("Doohickey USB")) {
                revealCharacters(wordHidden, randomWord);
                addedTries += 1;
            } else if (intellect >= 4) {
                addedTries += 2;
            } else {
                delaySpeech(1250);
                slowType("We dont got anyone smart enough to crack it...I guess I'll try.", 150);
            }

            slowType("It looks like we need to guess letters to form a word.", 100);
            char userGuess = charReader.next().charAt(0);
            
            int attempts = wordLength + 2 + addedTries; // Maximum number of attempts

            //  This loop allows the game to go through many attempts
            while (attempts > 0) {
                if (randomWord.indexOf(userGuess) != -1) {
                    // Correct guess: Update wordHidden
                    for (int i = 0; i < randomWord.length(); i++) {
                        if (randomWord.charAt(i) == userGuess) {
                            wordHidden = wordHidden.substring(0, i) + userGuess
                                    + wordHidden.substring(i + 1);
                        }
                    }
                    randomGameDialog(true);
                    System.out.println(wordHidden);
                } else {
                    randomGameDialog(false);
                    System.out.println(wordHidden); // Display random message
                }
                attempts--; // Decrement attempts

                if (wordHidden.equals(randomWord)) {
                    // If letters are guessed correctly, then it breaks the loop
                    System.out.println("Alright! We got it! Let's get out of here");
                    break;
				} else {
					money -= (money * 0.05);
				}
                if (attempts > 0) {
                    userGuess = charReader.next().charAt(0);
                }
            }

            gameInProgress = false; // Ends game
        }
		return money;
    }
    
    // Method adjusts difficulty if the intellect stat is high
    public static void revealCharacters(String wordHidden, String randomWord) {
        // Loop runs twice, reveals two characters
        for (int i = 0; i < 2; i++) {
            // randomly chooses index for letter revealed
            int index = (int) (Math.random() * randomWord.length());
            if (wordHidden.charAt(index) == '*') {
                // sees if there are asteriks and changes them to revealed characters
                wordHidden = wordHidden.substring(0, index) + randomWord.charAt(index) + wordHidden.substring(index + 1);
            }
        }
        slowType("Ahh...The Doohickey is helping us. " + wordHidden, 150);
    }


    public static void randomGameDialog(boolean isCorrect) {
        if (isCorrect) {
            String[] positiveDialogs = {"Nice!", "Keep at it man!", "Good", "Beautiful",
                                       "Very Cool!", "I might take you out after this.",
                                       "Keep it going", "Keep it rolling", 
                                        "Imma go gamble with this luck",
                                       "Great, keep at it", "Good!", "Nice", "We are darn close!",
                                       "Very Cool!", "Nice", "Great", ":)", ":)", "Closer to escaping!"};
            System.out.print("You: ");
            System.out.println(positiveDialogs[(int) (Math.random() * positiveDialogs.length)]);       
        } else {
            String[] negativeDialogs = {"Keep trying Man!", "Wrong, Damn!", "Well, Damn!",
                                       "Bro try! Cmon!!", "We might not make it at this rate.",
                                       "Im going to take your share if you keep this up.", 
                                       "Imma leave you if you dont solve this", "Sigh",
                                       "Oh my", "Cmon you scrub!", ":( ", "... ", "...", "..."};
            System.out.print("You: ");
            System.out.println(negativeDialogs[(int) (Math.random() * negativeDialogs.length)]);
        }
    }
    
    // Method for statCheck
    public static boolean statCheckCalculator(int multiplier, double percent) {
		double successChance = multiplier * percent; // success is based on the skill multiplier and base chance of working
		
		double randomNum = Math.random();
		
		return (randomNum < successChance); // if the randomNum 0-99 is less than successChance, the skill check passes true
	}
    
    // Method for tool choice
    public static String toolChoice(Scanner charReader, int intellect, 
                                    int strength, int sneak, int intimidate) {
        System.out.println("Type the letter of which tool you want to bring\nA." 
                           + " Doohickey USB\n" 
                           + "B. Steroids\nC. Noise-Cancellation Boots\nD. Bigger Gun");

        String toolName = "";
        char inputToolChoice = charReader.next().charAt(0);
        
        		switch(Character.toUpperCase(inputToolChoice)) {
			case 'A':
				toolName = "Doohickey USB"; 
				intellect += 2; break;
			case 'B':
				toolName = "Steroids"; 
				strength += 2; break;
			case 'C':
				toolName = "Noise-Cancellation Boots"; 
				sneak += 2; break;
			case 'D':
				toolName = "Bigger Gun"; 
				intimidate += 2; break;
			default:
				toolName = "Steroids";
				strength += 2;
				System.out.println("You didn't choose a possible option, so you're stuck with Steroids.\n");
				delaySpeech(3);
		}
        delaySpeech(300);
		slowType("DRIVER: Nice choice, the " + toolName + " will be useful.", 125);
        delaySpeech(200);
        return toolName;

    }
    
    
    // Method for partner choice of user
    public static String partnerChoice(Scanner charReader, int intellect, 
                                       int strength, int sneak, int intimidate) {
        System.out.println("Type the letter of which partner you want to bring\nA. Nerd\n" +
                "B. Brute\nC. Sly\nD. Menace");

        String partnerName = "";
        char inputPartnerChoice = charReader.next().charAt(0);

        switch (Character.toUpperCase(inputPartnerChoice)) {
            case 'A':
                partnerName = "Nerd";
                intellect += 4;
				sneak += 2;
				strength += 1;
                break;
            case 'B':
                partnerName = "Brute";
                strength += 4;
				intimidate += 2;
				sneak += 1;
                break;
            case 'C':
                partnerName = "Sly";
				sneak += 4;
				intellect += 2;
				intimidate += 1;
                break;
            case 'D':
                partnerName = "Menace";
                intimidate += 4;
				strength += 2;
				intellect += 1;
                break;
            default:
                partnerName = "Nerd";
                intellect += 4;
				sneak += 2;
				strength += 1;
                System.out.println("You didn't choose a possible option, so you're stuck with the Nerd.\n");
                delaySpeech(3);
        }
        delaySpeech(1);
        System.out.print("DRIVER: Really? You chose the... " + partnerName + "?");
        delaySpeech(2);
        return partnerName;
    }
    
    //Method for -help mode

    public static void displayHelp() {
        delaySpeech(1500);
        slowType("You Picked the \"-help\" mode", 150);
        delaySpeech(1000);
        slowType("Think of this as a \"Guided Experience\"", 150);
        delaySpeech(1000);
        slowType("I will be your tour guide today. My name is Dandy", 150);
        delaySpeech(2500);
        slowType("Loading...\f\f\f", 150);
    }
    
    // Method for the first part of the game: Prelude
    public static void prelude(Scanner charReader) {
               String[] film = new String[19];
         
         film[0]   = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n";
        
        film[1]    = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )    *    |\n" +
                     "|  (   (       )      ))      |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|        .     .              |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n";
        
        film[2]    = "0123456789012345678901234567890\n" +
                     "|        -  --             *  |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))      |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|    .          .             |\n" +
                     "|        .       .            |\n" +
                     "|                             |\n" +
                     "|                             |\n" +
                     "|                             |\n";
        
         film[3]   = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )      *  |\n" +
                     "|  (   (       )      ))      |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|          .           .      |\n" +
                     "|      .      .  .            |\n" +
                     "|         .      .            |\n" +
                     "|                             |\n" +
                     "|                             |\n";
        
         film[4]   = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )          *  |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))      |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|    .   .        .  .        |\n" +
                     "|     ,     .  .       .      |\n" +
                     "|       .      .    .         |\n" +
                     "|           .     .           |\n" +
                     "|         .                   |\n";
        
        film[5]    = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|  .    .  .    .   .     .   |\n" +
                     "|    .     .   ,       .      |\n" +
                     "|       ,      .        .     |\n" +
                     "|     .    .     .   ,        |\n" +
                     "|             .     .         |\n";
        
        film[6]    = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )   *     |\n" +
                     "|  (   (       )      ))      |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|    ,      .  .        .     |\n" +
                     "|              .   ,      .   |\n" +
                     "|   .    ,   .                |\n" +
                     "|     .    .      .     ,     |\n" +
                     "|        .    .               |\n";
        
        
        film[7]    = "0123456789012345678901234567890\n" + 
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|  .   . .    .    ,    .     |\n" +
                     "|    .  .   .    .         .  |\n" +
                     "|       .   ,  .     .   ,    |\n" +
                     "|     .   . .      .      .   |\n" +
                     "|    .  ,   .     .    .      |\n";
        
        film[8]    = "0123456789012345678901234567890\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|     .    .   . .            |\n" +
                     "| .     .    ,   .   .  .     |\n" +
                     "|   .          .  ,  .        |\n" +
                     "|     .    .   .         .    |\n" +
                     "|     ,         .       .     |\n";
        
        film[9]    = "|                             |\n" +
                     "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|     .    .   . .            |\n" +
                     "|        ,   .   .   ,  .     |\n" +
                     "|  .  .   .    ,     .        |\n" +
                     "|       .  .       .     .    |\n" +
                     "|     .        .        .     |\n";
        
        
        film[10]  =  "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|     .    ,   .              |\n" +
                     "| .    .     .   .   .  .     |\n" +
                     "|   .     .    .     ,        |\n" +
                     "|     .    ,       .     .    |\n" +
                     "|     .     .   .       ,     |\n" +
                     "| .     .        .   .  .     |\n";
        
        film[11]  =  "|        -  --                |\n" +
                     "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|          .   . ,            |\n" +
                     "| .  .  .    .   .   ,  .     |\n" +
                     "|         ,    .  .  .        |\n" +
                     "|   ,   .         .     .     |\n" +
                     "|     .      .  ,       .     |\n" +
                     "| .                  .        |\n";
        
        film[12]  =  "|  *    (   )   )             |\n" +
                     "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|     .        . ,            |\n" +
                     "| ,         .  .   .          |\n" +
                     "|     .   .    ,  .  .        |\n" +
                     "|     . ,  .   .   .          |\n" +
                     "|     .         .             |\n" +
                     "|   .      .   . ,      .     |\n" +
                     "| .     .        .   .  .     |\n";
        
        film[13]  =  "|    (      )    )  )         |\n" +
                     "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|     .    .   . ,            |\n" +
                     "| .      .   ,          .     |\n" +
                     "|   ,     .    .     .        |\n" +
                     "|     .    .       ,     .    |\n" +
                     "|                      .      |\n" +
                     "|   .     ,       .  .        |\n" +
                     "|     .    .   .         .    |\n" +
                     "| .     .        ,   .  .     |\n";
        
        film[14]  =  "|  (   (       )      ))    * |\n" +
                     "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|                   .         |\n" +
                     "| .     .    .   .   .  .     |\n" +
                     "|         ,    .  .  .        |\n" +
                     "|     .        ,   .     .    |\n" +
                     "|    ,     ,            .     |\n" +
                     "|   .          .  .  .        |\n" +
                     "|     .    .   .         .    |\n" +
                     "|           ______            |\n";
        
        film[15]  =  "|    ~~~~~  ~~~~~~~  ~        |\n" +
                     "|                   .         |\n" +
                     "| .     ,    .   .   .  .     |\n" +
                     "|         .    .  ,  .        |\n" +
                     "|     ,        .   .     .    |\n" +
                     "|    .      .   .       .     |\n" +
                     "|        .   ,          .     |\n" +
                     "|   ,          .  .  .        |\n" +
                     "|           ______            |\n" +
                     "|         /        \\          |\n"; 
        
        film[16]  =  "|           ,                 |\n" +
                     "|    .         .       ,      |\n" +
                     "|        .          .         |\n" +
                     "|   .    ,    ,    .          |\n" +
                     "|          .          .       |\n" +
                     "|               .    .        |\n" +
                     "|       . .            .      |\n" +
                     "|           ______            |\n" +
                     "|    .    /__    __\\   .      |\n" +
                     "|        {0:= || =:0}         |\n";
        
        film[17]  =  "|     .     .                 |\n" +
                     "|    .           .     ,      |\n" +
                     "|        ,   .    .      .    |\n" +
                     "|          .    .       ,     |\n" +
                     "|     .        ,     .        |\n" +
                     "|   .     .            .      |\n" +
                     "|      .    ______            |\n" +
                     "|         / __  __ \\          |\n" +
                     "|    . ^ {0:= || =:0}  .      |\n" +
                     "|    ^    ----------      .   |\n";
        
        film[18]  =  "|    .           .     .      |\n" +
                     "|        ,   .    .      .    |\n" +
                     "|          .    ,       .     |\n" +
                     "|     ,              .        |\n" +
                     "|   .     .    ,       .      |\n" +
                     "|      .    ______            |\n" +
                     "|         / __  __ \\          |\n" +
                     "|    .   {0:= || =:0}  .      |\n" +
                     "|      ^  ----------      .   |\n" +
                     "|    ^            ^     ^     |\n" ;
        
        
        // Loops through array while printing its contents
        for (int i = 0; i < film.length; i++) {
            if (i == 0) {
                // At index 0 it slowTypes the image
                slowType(film[i], 10);
            } else if (i >= 4 && i <= 8) {
                for (int j = 0; j < 10; j++) {
                    //During index 4 through 8 it prints them 10 times
                    System.out.println("\f\f\f\f\f\f\f");
                    delaySpeech(30);
                    System.out.println(film[i]);
                }
            } else if ( i >= 9 && i < 14) {
                System.out.println("\f\f\f\f\f\f\f");
                delaySpeech(250);
                System.out.println(film[i]);
            } else {
                System.out.println("\f\f\f\f\f\f\f");
                delaySpeech(375);
                System.out.println(film[i]);
            }
        }
        
        
        
        System.out.println("\f\f\f\f\n");
        System.out.print("Heavy Rain");
        delaySpeech(2000);
        // Overwrite the text with new text by using \r, as seen in chap 4
        System.out.print("\rHits The Roof.");
        delaySpeech(2200);
        System.out.print("\rThey wonder when the next one will be.");
        delaySpeech(3000);
        System.out.println("\rOr if there will be a next one. Should they leave it all?");
        
        // User can quit the game right off the bat
        delaySpeech(2000);
        System.out.print("Yes(Y) or No(N): ");
        char quitOrNot = charReader.next().charAt(0);
        
        if (quitOrNot == 'Y' || quitOrNot == 'y') {
            // If the player chooses to quit, the program will exit
            delaySpeech(1000);
            slowType("\"I dont think I have it no more. " 
                     + "The world is changing and so should I\"", 140);
            gameTime();
            System.exit(0); 
        } else {
            delaySpeech(1000);
            slowType("They think to themselves, \"Why Not Continue\"", 120);
            delaySpeech(1000);
            slowType("The Morning Arrives\f\f", 120);
        }
        
        System.out.println("\f\f");

    }
    
    // Method to tell user how long the game lasted
    public static void gameTime() {
            long endTime = System.currentTimeMillis();
            long testTime = endTime - programStart;
                if((testTime * 0.001) / 60 < 1 ){
                    System.out.printf("Program ran for: %.2f seconds.", testTime * 0.001);
                } else {
                    long minutes = (testTime / 1000) / 60;
                    long seconds = (testTime / 1000) % 60;
                    System.out.println( "Program ran for: "
                                        + minutes + " minutes, and "
                                        + seconds + " seconds.");
                }       
    }

    // Delays when speech comes out
    public static void delaySpeech(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
    
    // Slows down text by character
    public static void slowType(String s, int slowDelay) {
       for(int i = 0; i < s.length(); i++) {
           System.out.print(s.charAt(i));
           delaySpeech(slowDelay);
       }
       System.out.println();
       
   }
    
}


