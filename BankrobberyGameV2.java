import java.util.Scanner;
public class BankRobberyGameV2 {
	public static void main(String[] args) {
		// STATS
		int intellect = 1;
		int strength = 1;
		int sneak = 1;
		int intimidate = 1;
		double money = 0;
		Scanner charReader = new Scanner(System.in);

		// INTRODUCTION
		System.out.println("DRIVER: Hey boss, where will our next score be?");
		delaySpeech(2); // delay is 2 seconds
		System.out.println("DRIVER: Bank of Chase Fargo?");
		delaySpeech(2);
		System.out.println("DRIVER: Oooh that's going to be tough, I think we should get some help.");
		delaySpeech((long)2.3);
		System.out.println("DRIVER: So who should we get?");
		delaySpeech(2);
		
		// PARTNER CHOICE
		System.out.println("Type the letter of which partner you want to bring\nA. Nerd\n" +
						  "B. Brute\nC. Sly\nD. Menace");
		
		String partnerName;
		
		char inputPartnerChoice = charReader.next().charAt(0);
		
		switch(Character.toUpperCase(inputPartnerChoice)) {
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
		System.out.println("DRIVER: Really? You chose the... " + partnerName + "?");
		delaySpeech(2);
		System.out.println("DRIVER: ... Alright then, what tool do we need?");
		// TOOL CHOICE
		System.out.println("Type the letter of which tool you want to bring\nA. Doohickey USB\n" +
						  "B. Steroids\nC. Noise-Cancellation Boots\nD. Bigger Gun");
		
		String toolName;
		
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
		
		System.out.println("DRIVER: Nice choice, the " + toolName + " will be useful.");

//		System.out.println("intelligence is " + intellect); // debug code
//		System.out.println("Strength is " + strength); // debug code
//		System.out.println("sneak is " + sneak); // debug code
//		System.out.println("intimidate is " + intimidate); // debug code
		delaySpeech(2);
		System.out.println("\nYour driver takes you to the bank.");
		delaySpeech(3);
		System.out.println("You stake out the place to look for an opening.");
		delaySpeech(4);
		System.out.println("You think in your head that you can enter through " 
						   + "the:\nA. Front Door\nB. Back Door");
		char inputEntranceChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputEntranceChoice) == 'A') {
			money = frontDoorRobbery(partnerName, toolName, money, intellect, strength, sneak, intimidate);
		} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
			money = backDoorRobbery(partnerName, toolName, money, intellect, strength, sneak, intimidate);
		} else {
			System.out.println("You didn't choose a viable option, so you are" +
							  " taking the front entrance.");
			money = frontDoorRobbery(partnerName, toolName, money, intellect, strength, sneak, intimidate);
		}
		charReader.close(); // not necessary for this project bc it's so small, but good practice
		
		System.out.println("YOU STOLE $" + (int) money + "!");
		if (money > 0)
		System.out.println("CONGRATS!");
	}
	
	public static void delaySpeech(long duration) { // This needs to long
		try {
			Thread.sleep(duration * 1000); // sleep uses milliseconds, so converts seconds to milli-
		}
		catch (Exception e) { // need this or else it causes errors
			System.out.println(e);
		}
	}
	
	
	public static boolean statCheckCalculator(int multiplier, double percent) {
		double successChance = multiplier * percent; // success is based on the skill multiplier and base chance of working
		
		//System.out.println(successChance); // debug code
		
		double randomNum = Math.random();
		
		// System.out.println(randomNum); // debug code
		
		return (randomNum < successChance); // if the randomNum 0-99 is less than successChance, the skill check passes true
	}
	
	
	public static double frontDoorRobbery(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
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
    	if(statCheckCalculator(intimidate,0.20)) {
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
				money = yellAtTeller(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else if (Character.toUpperCase(inputTellerChoice) == 'B') {
				money = breakThroughDoor(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}
		return money;
	}
	
	
	public static double yellAtTeller(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
		System.out.println("\nYou chose to yell at the bank teller.\n");
		
		
		System.out.println("You kick the door open and heads towards the Bank Teller pointing his gun at him.");
		delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
		delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
		delaySpeech(2);
		System.out.println("The teller points to the back");
		delaySpeech(2);
        System.out.println("PLAYER: OPEN THE DOOR NOW!!!!!");
		delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not here.");
		delaySpeech(2);
        System.out.println("PLAYER: DAMN!!!! OK LET'S SEE IF I COULD LOCK PICK THIS THEN!!!!");
		delaySpeech(2);
		
    	boolean resultOfLockPick = lockPickMini(partnerName);
		
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
	
	
	public static double breakThroughDoor(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
		System.out.println("\nYou chose to break through the door.\n");
		
		System.out.println("You kick the door open and heads towards the Bank Teller pointing his gun at him.");
		delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
		delaySpeech(2);
        System.out.println("Bank teller: D-d-down th-there");
		delaySpeech(2);
		System.out.println("The teller points to the back");
		delaySpeech(2);
        System.out.println("PLAYER: OPEN THE DOOR NOW!!!!!");
		delaySpeech(2);
        System.out.println("Bank Teller: I don't have the key for that. The manager does and he's not here.");
		delaySpeech(2);
        System.out.println("PLAYER: Ok, let's get a move on buddy.");
		delaySpeech(2);
    	System.out.println("PLAYER and the Bank Teller head towards the vault.");
		delaySpeech(2);
        System.out.println("PLAYER: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
		delaySpeech(2);
        System.out.println("Bank Teller: Is, 6-4-2. That's the code for the vault.");
		delaySpeech(2);
		System.out.println("TELLER: Ok, there it's open.");
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
		System.out.println("You meet up with " + partnerName +
						  " and escape to the car.");
		return money;
	}
	
	public static double backDoorRobbery(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
		System.out.println("\nYou are sneaking through the back door with partner.\n");
		
		delaySpeech(3);
		System.out.println(partnerName + ": Watch out for the cameras, let me disable them");
		delaySpeech(1);
		slowType("...",500);
		System.out.println(partnerName + ": we cracked it. we don't " +
						   "have much time, let's go.");
		delaySpeech(3);
		System.out.println("Both of you make it to the vault door and your partner unlocks it.");
		delaySpeech(3);
		System.out.println(partnerName + ": grab some money and let's get out of here.");
		delaySpeech(3);
		money += 200000;
		System.out.println("You think to yourself if \nA. going up the vent \nor \nB. going back up the stairs\nis better?: ");
		
		char inputExitChoice = '~';
		while (Character.toUpperCase(inputExitChoice) != 'A' ||
			  Character.toUpperCase(inputExitChoice) != 'B') {
			inputExitChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputExitChoice) == 'A') {
				money = throughVents(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else if (Character.toUpperCase(inputExitChoice) == 'B') {
				money = throughStairs(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}
		return money;
	}
	
	public static double throughVents(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
		money -= (money * 0.02);
		
		System.out.println("\nYou chose to go up the vent.\n");
		
		
		System.out.println(partnerName + ": alright. shhh.");
		delaySpeech(2);
        System.out.println(partnerName + ": in here.");
		
        if(statCheckCalculator(sneak,0.20)) {
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
		System.out.println("You can:\nA. run up front to jump off the roof into some bushes \nor \nB. climb down the side.");
		
		char inputRoofChoice = '~';
		while (Character.toUpperCase(inputRoofChoice) != 'A' ||
			  Character.toUpperCase(inputRoofChoice) != 'B') {
			inputRoofChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputRoofChoice) == 'A') {
				money = jumpFrontDown(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else if (Character.toUpperCase(inputRoofChoice) == 'B') {
				money = climbDownSide(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}

		return money;
	}
	
	public static double jumpFrontDown(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
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
	
	public static double climbDownSide(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
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
	
	public static double throughStairs(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
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
		money = stairsOptionGame(intellect, money);
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
				money = shootTheGuard(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else if (Character.toUpperCase(inputOutsideChoice) == 'B') {
				money = talkWithGuard(partnerName, toolName, money, intellect, strength, sneak, intimidate);
				break;
			} else {
				System.out.println("That isn't A or B");
			}
		}
		
		return money;
	}
	
	public static double shootTheGuard(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
		money -= (money * 0.03);
		
		System.out.println("\nYou chose to shoot the guard.\n");
	
        System.out.println("You hit one of the guards, but your partner misses");
		delaySpeech(2);
        System.out.println(partnerName + ": RUN!");
		delaySpeech(2);
		System.out.println(partnerName + ": THERE'S THE CAR!");
		delaySpeech(3);
        System.out.println("You book it to the backseat. While your partner takes the front seat.");
		System.out.println("Your team successfully escape ");
		
		return money;
	}
	
	public static double talkWithGuard(String partnerName, String toolName, double money,
									   int intellect, int strength, int sneak, int intimidate) {
		Scanner charReader = new Scanner(System.in);
		
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
	
	public static boolean lockPickMini(String partnerName) {
        Scanner scanner = new Scanner(System.in);
        
        int[] lockCombination = generateCombination();
        
        System.out.println("Hurry up and pick the lock");
        System.out.println("You need to pick the lock by correctly setting the pins.");
        System.out.println("The lock has 4 pins. Each pin's value ranges from 0 to 9.");
        System.out.println("Enter your guess for each pin and try to unlock the door!");
        
		// number of tries 
        for (int attempts = 1; attempts <= 5; attempts++) {
            System.out.println("\nAttempt " + attempts + ":");
            int[] playerGuess = getPlayerGuess(scanner);
            
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
    public static int[] getPlayerGuess(Scanner scanner) {
        int[] guess = new int[4];
        System.out.print("Enter your guess (4 numbers separated by spaces): ");
        for (int i = 0; i < 4; i++) {
            guess[i] = scanner.nextInt();
        }
        return guess;
    }
    

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
	public static double stairsOptionGame(int intellect, double money){
        Scanner charReader = new Scanner(System.in);
        
//        delaySpeech(1); 
//        System.out.println("Alright!");
//        delaySpeech(1); 
//        System.out.println("Let's get moving.");
//        delaySpeech(1);
//        slowType("Hold on. Let me check ...\nDamn!\nThey activated an alarm", 120);
//        delaySpeech(2); 
//        slowType("Okay...Okay...\nShut\nIt\nDown\nNow!!!\n", 150);
		slowType("Initializing...\nNODUS", 150);
        
        // Array holding strings for hang-man type game.
        String[] gameWords = {"Laundrette", "Flukas", "Dreams", "Thief",
                              "Autumn", "Afternoon", "Human", "Condition",
                              "Loser", "Game", "Cat", "Computer", "Liang",
                              "Chips", "Seven", "Granola"};
        
        boolean gameInProgress = true;
        String randomWord;
        int addedTries = intellect / 2;
        
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
            if (intellect >= 7) {
                addedTries += 2;
                revealCharacters(wordHidden, randomWord, addedTries);
            } else if (intellect >= 2 && intellect <= 6) {
                addedTries += 1;
            } else {
                delaySpeech((long)1.25);
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
    public static void revealCharacters(String wordHidden, String randomWord, int numCharacters) {
        for (int i = 0; i < numCharacters; i++) {
            int index = (int) (Math.random() * randomWord.length());
            if (wordHidden.charAt(index) == '*') {
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
            System.out.println(positiveDialogs[(int) (Math.random() * positiveDialogs.length)]);
        } else {
            String[] negativeDialogs = {"Keep trying Man!", "Wrong, Damn!", "Well, Damn!",
                                       "Bro try! Cmon!!", "We might not make it at this rate.",
                                       "Im going to take your share if you keep this up.", 
                                       "Imma leave you if you dont solve this", "Sigh",
                                       "Oh my", "Cmon you scrub!", ":( ", "... ", "...", "..."};
            System.out.println(negativeDialogs[(int) (Math.random() * negativeDialogs.length)]);
        }
    }
	
    // Slows down text by character
    public static void slowType(String s, int slowDelay) {
       for(int i = 0; i < s.length(); i++) {
           System.out.print(s.charAt(i));
           delaySpeechMilli(slowDelay);
	   }
       System.out.println();
       
   }
    public static void delaySpeechMilli(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
