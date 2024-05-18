import java.util.Scanner;
public class BankFinalVer {
    // This constant tells us when the prgram started.
    public static final long programStart = System.currentTimeMillis();
    
    public static void main(String[] args) {
        
        // STATS
		int intellect = 1;
		int strength = 1;
		int sneak = 1;
		int intimidate = 1;
		double money = 0;
        
        boolean helpMode = false;
		
        Scanner charReader = new Scanner(System.in);
        
        // Game Start: Tells you what mode you have selected
        if(args.length != 0 && args[0].equals("-help")) {
            displayHelp();
            helpMode = true;
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
        // Help mode gets called if user selected it.
        helpPartner(helpMode);
        String partnerName = partnerChoice(charReader, intellect, strength, sneak, intimidate);
        System.out.println("\nChosen Partner: " + partnerName + "\n");
        
        
        // Tool Choice
        delaySpeech(2);
        helpTool(helpMode, partnerName);
		System.out.println("DRIVER: ... Alright then, what tool do we need?");
        String toolName = toolChoice(charReader, intellect, strength, sneak, intimidate);
        System.out.println("\nChosen Tool: " + toolName);
      
        
        // Bank entrance Option: Front or Back
        delaySpeech(2);
		System.out.println("\nYour driver takes you to the bank.");
		delaySpeech(3);
		System.out.println("You stake out the place to look for an opening.");
        // Help mode tour guide gets increasingly mad if you go against her choices.
        helpEntrance(helpMode, toolName, partnerName);
		delaySpeech(50);
		System.out.println("You think in your head that you can enter through " 
						   + "the:\nA. Front Door\nB. Back Door");
		char inputEntranceChoice = charReader.next().charAt(0);
		if (Character.toUpperCase(inputEntranceChoice) == 'A') {
            money = frontDoorRobbery(charReader, partnerName, toolName, money, intellect, strength, 
                                     sneak, intimidate, helpMode);
		} else if (Character.toUpperCase(inputEntranceChoice) == 'B') {
			money = backDoorRobbery(charReader, partnerName, toolName, money, intellect, strength,
                                    sneak, intimidate, helpMode);
		} else {
			System.out.println("You didn't choose a viable option, so you are" +
							   " taking the front entrance.");
			money = frontDoorRobbery(charReader, partnerName, toolName, money, intellect, strength,
                                     sneak, intimidate, helpMode);
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
                                          int sneak, int intimidate, boolean helpMode) {
        System.out.println("\nYou chose to go through the Front Door.\n");
        delaySpeech(3);
        System.out.println(partnerName + ": This is it, let's go!");
        delaySpeech(3);
        System.out.println("You bust through the door with " + partnerName);
        delaySpeech((long)0.25);
        helpFrontDoor(helpMode);
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
        helpTellerOption(helpMode);
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
    
    public static double breakThroughDoor(Scanner charReader, String partnerName, String toolName,                                              double money, int intellect, int strength, int sneak, 
                                           int intimidate) {
        System.out.println("\nYou chose to break through the door.\n");
    
        System.out.println("You kick the door open and heads towards the Teller pointing your gun at him.");
		delaySpeech(3);
        System.out.println("YOU: WHERE IS THE MONEY!!!");
		delaySpeech(2);
        System.out.println("TELLER: D-d-down th-there");
		delaySpeech(2);
		System.out.println("The teller points to the back");
		delaySpeech(2);
        System.out.println("YOU: OPEN THE DOOR NOW!!!!!");
		delaySpeech(3);
        System.out.println("TELLER: I don't have the key for that. The manager does and he's not here.");
		delaySpeech(3);
        System.out.println("YOU: Ok, let's get a move on buddy.");
		delaySpeech(3);
    	System.out.println("You and the Bank Teller head towards the vault.");
		delaySpeech(3);
        System.out.println("YOU: OK, WHAT'S THE CODE FOR THE VAULT!!!!");
		delaySpeech(3);
        System.out.println("TELLER: Is, 6-4-2. That's the code for the vault.");
		delaySpeech(3);
		System.out.println("TELLER: Ok, there it's open.");
		delaySpeech(3);
        System.out.println("YOU: FINALLY! GET INSIDE AND STAY RIGHT THERE.");
		delaySpeech(3);
		money += 175000;
		System.out.println("As you take out your bag to collect the money, the " +
						  "teller jumps onto your back.");
		delaySpeech(4);
		System.out.println("TELLER: I WON'T LET YOU ROB THIS BANK!");
		delaySpeech(3);
		System.out.println("You're starting to lose control of your actions.");
		delaySpeech(3); 
		if (statCheckCalculator(0,0.666)) {
			System.out.println("\nYou were able to control yourself.\n");
			System.out.println("You pushed the bank teller off you.");
			delaySpeech(3);
		} else {
			if(statCheckCalculator(0,0.666)) {
				System.out.println("\nYou were not able to control yourself\n");
				delaySpeech(3);
				System.out.println("You killed the bank teller.");
			} else {
				System.out.print("\nWait");
				slowType("...",900);
				System.out.println("You died from steroid use.");
				delaySpeech(1);
				System.out.println(partnerName + " was arrested shortly after.");
				delaySpeech(1);
				System.out.println("You lost.");
				money *= 0;
				return money;
			}
		}
		System.out.println("You head back up to meet with " 
						   + partnerName+".");
        System.out.println("YOU: OK, Got the dough. Lets go.");
		delaySpeech(3);
        System.out.println(partnerName + ": Got it. Let's go to the back door.");
		delaySpeech(2);
        System.out.println("YOU: Ok, meet you there.");
		System.out.println("You meet up with " + partnerName +
						  " and escape to the car.");
		
		return money;
	}
    
    // Method for the Back door approach
    public static double backDoorRobbery(Scanner charReader, String partnerName, String toolName, double                                            money, int intellect, int strength, int sneak, int intimidate,
                                         boolean helpMode) {
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
        helpBackDoor(helpMode);
        System.out.println("You think to yourself if \nA. going up the vent \nOr \nB. going back up the"                           + " stairs is better?: ");
    
        char inputExitChoice = '~';
        while (Character.toUpperCase(inputExitChoice) != 'A' ||
            Character.toUpperCase(inputExitChoice) != 'B') {
            inputExitChoice = charReader.next().charAt(0);
            if (Character.toUpperCase(inputExitChoice) == 'A') {
                money = throughVents(charReader, partnerName, toolName, money, intellect, strength,
                                     sneak, intimidate, helpMode);
                break;
            } else if (Character.toUpperCase(inputExitChoice) == 'B') {
                money = throughStairs(charReader, partnerName, toolName, money, intellect, strength,
                                      sneak, intimidate, helpMode);
                break;
            } else {
                System.out.println("That isn't A or B");
            }
        }
        return money;
    }

    // Method for vent option
    public static double throughVents(Scanner charReader, String partnerName, String toolName, double money,
                                      int intellect, int strength, int sneak, int intimidate, 
                                      boolean helpMode) {
        money -= (money * 0.02);
		
		System.out.println("You chose to go up the vent.");
		
		
		System.out.println(partnerName + ": alright! shhh.");
		delaySpeech(2);
        System.out.println(partnerName + ": in here.");
		delaySpeech(2);
		System.out.println("Your follow " + partnerName +
						  " into the vents.");
		delaySpeech(2);
		System.out.println(partnerName + ": let's get to the roof.");
		delaySpeech(2);
		System.out.println("GUARD: HEY! SOMEONE BROKE IN!");
		delaySpeech(2);
        System.out.println("Your partner's eyes begin to widen.");
		delaySpeech(2);
		System.out.println(partnerName + " mouths shhhh to quiet you");
		if (toolName == "Noise-Cancellation Boots") {
			System.out.println("Fortunately you have the " + toolName +
							  " so your steps were silent as you crawl through the vents.");
			delaySpeech(2);
			System.out.println(partnerName + ": c'mon");
			delaySpeech(2);
			System.out.println("You make it to the roof.");
			delaySpeech(2);
			System.out.println(partnerName + ": Where do we go now?");
			delaySpeech(3);
			System.out.println("You can" +
							   "\nA. run up front to jump off the roof into some bushes," 
							   + "\nor \nB. climb down the side.");
			char inputRoofChoice = charReader.next().charAt(0);
			if (Character.toUpperCase(inputRoofChoice) == 'A') {
				System.out.println("You chose to jump off the front of the building");
			} else if (Character.toUpperCase(inputRoofChoice) == 'B') {
				System.out.println("You chose to climb down the side of the building");
			}
		} else {
			System.out.println("As you walk through the vents, " +
							   "you try your hardest to not make noise");
			if (statCheckCalculator(sneak,0.14)) {
				System.out.println("You succeeded the stat check.");
			} else {
				System.out.println("You failed the stat check.");
				System.out.println("The guards start to shoot at you");
				if (Math.random() < (sneak * 0.14)) {
					System.out.println("You and " + partnerName +
									  "scramble and climb up the ladder.");
					money -= (money * 0.02);
				} else {
					System.out.println("You get shot and died.");
					delaySpeech(2);
					System.out.println("You lost.");
					money -= (money * 0);
					return money;
				}
			}
		}
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
                                       int intellect, int strength, int sneak,
                                       int intimidate, boolean helpMode) {
		
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
                                 strength, sneak, intimidate, helpMode);
		//System.out.println(partnerName + ": Alright. Let's get out of here");
		delaySpeech(3);
		System.out.println("Both of you make it out the back door of the building.");
		delaySpeech(3);
		System.out.println("Hey what are you two doing here");
		delaySpeech(2);
		System.out.println("You turn around to see two guards looking at you from the door.");
		delaySpeech((long)0.5);
        helpGuardOption(helpMode);
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
		
		System.out.println("You chose to shoot the guard.");
		
		if (timeSkillCheck()) {
			System.out.println("You successfully shot the guard.");
			System.out.println("You hit one of the guards, but your partner misses");
			delaySpeech(2);
			System.out.println(partnerName + ": RUN!");
			delaySpeech(2);
			System.out.println(partnerName + ": THERE'S THE CAR!");
			delaySpeech(3);
		} else {
			System.out.println("You and " + partnerName + " failed to shoot the guard.");
			delaySpeech(2);
			System.out.println("The guards shot back");
			delaySpeech(2);
			System.out.println("You get hit in the shoulder," +
							   " but you manage to get to your car.");
			money -= (money * 0.10);
			delaySpeech(2);
		}
		System.out.println("You book it to the backseat. " +
						   "While your partner takes the front seat.");
		System.out.println("Your team successfully escape");
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
    
    public static double stairsOptionGame(Scanner charReader, String partnerName, String toolName, 
                                          double money, int intellect, int strength, int sneak, 
                                          int intimidate, boolean helpMode) {
		
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
                slowType(partnerName + ": "
                         + "We dont got anyone smart enough to crack it...I guess I'll try.", 150);
            }
            helpHangMan(helpMode);

            slowType(partnerName + ": " + "It looks like we need to guess letters to form a word.", 100);
            char userGuess = charReader.next().charAt(0);
            
            int attempts = wordLength + 2 + addedTries; // Maximum number of attempts

            //  This loop allows the game to go through many attempts
            while (attempts > 0) {
                if (randomWord.indexOf(userGuess) != -1) {
                    // Correct guess: Update wordHidden, checks if guess is within word
                    // After it goes through the word to check what index the corrrect guess is at
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
                    System.out.println(partnerName + ": " + "Alright! We got it! Let's get out of here");
                    break;
				} else {
					money -= (money * 0.05);
				}
                // Gets user input if attempts over zero
                if (attempts > 0) {
                    userGuess = charReader.next().charAt(0);
                }
                else  {
                    System.out.println(partnerName + ": " + "Lets just dip man, I cant figure this.");
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
    
    // All Methods for -help mode

    public static void displayHelp() {
        delaySpeech(1500);
        slowType("\n\nYou Picked the \"-help\" mode", 40);
        delaySpeech(1000);
        slowType("Think of this as a \"Guided Experience\"", 40);
        delaySpeech(1000);
        slowType("I will be your tour guide today. My name is Dandy. "
                 + "Today we will be robbing a bank, hopefully ;)", 70);
        delaySpeech(1500);
        slowType("Loading...\f\f\f", 70);
    }
    
    public static void helpPartner(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: Here we are given a choice of partner.", 50);
            slowType("Dandy: If you pick the nerd, you will get +4 added intellect. "
                     + "Additionally, they might come in handy for a future game ;)", 50);
            slowType("Dandy: Choosing the sly might be helpful if you want "
                     + "to be sneaky, or climb through vents", 50);
            delaySpeech(1000);
            slowType("Dandy: If you pick the brute, you will get +4 added strength. "
                     + "If I had to pick, I would choose the NERD or BRUTE", 50);
        }
    }
    
    public static void helpTool(boolean helpMode, String partnerName) {
        if (helpMode) {
            if (!partnerName.equals("Nerd") && !partnerName.equals("Brute")) {
                slowType("Dandy: You didn't choose my recommendation last time, "
                         + "hopefully you pick the right choice here. :]", 80);
            }

            delaySpeech(1000);
            slowType("Dandy: We are given a choice of tool.", 50);
            slowType("Dandy: If you pick the Doohickey USB, you might have "
                 + "an easier time when choosing to go upstairs.", 50);
            delaySpeech(1000);
            slowType("Dandy: I would recommend picking the USB.", 50);
        }
    }

    
    public static void helpEntrance(boolean helpMode, String toolName, String partnerName) {
        if (helpMode) {
            delaySpeech(1000);
            slowType("Dandy: We are given two options. Front or back door approach. "
                    + "The front door will get rowdy, while the back door will be quiet.", 40);
            slowType("Dandy: I would recommend the back door option.", 50);
            
            // This loop is nested, as if not, it would show up even if you didnt choose -help
            // This statement is for if the user didnt choose Dandys recommendations
            if (!partnerName.equals("Nerd") && !partnerName.equals("Brute") 
                                        && !toolName.equals("Doohickey USB")) {
            slowType("Dandy: Since you don't like my choices, pick what you want here :( ", 80);
            delaySpeech(1000);
            }
        }
    }
    
    public static void helpFrontDoor(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: You can either yell out for people to put their hands up "
                     + "or to put hands down, or to get on the ground", 80);
            slowType("Dandy: Since you picked the front door option, I would say to "
                     + "tell them to put their hands up.", 80);
        }
    }
    
       public static void helpTellerOption(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: Here you can yell at the teller, or break through the door. ", 80);
            slowType("Dandy: Yelling at the teller results in having to pick a lock. "
                     + "Breaking through the door results in intimidating the teller.", 80);
        }
    }
        public static void helpBackDoor(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: Here we are given two options: "
                     + "Go up the vent or up the stairs.", 50);
            delaySpeech(1000);
            slowType("Dandy: If you go up the stairs you will encounter a hang-man game", 80);
            slowType("Dandy: Going up the vent might be the safer option.", 80);
        }
    }
    
    public static void helpHangMan(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: A tip I could give you is that the first letter is a capital. "
                     + "Try inputing vowels(a,e,i,o,u), they appear a lot in the possible words. ", 50);

        }
    }
    
    public static void helpGuardOption(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: At this point just shoot them. Its a safer option", 80);

        }
    }
    
    public static void helpVentOption(boolean helpMode) {
        if (helpMode){
            delaySpeech(1000);
            slowType("Dandy: We can jump off the roof, or climb down. "
                     + "If you jump off you might hurt yourself. Maybe climb down.", 50);

        }
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
	public static boolean timeSkillCheck() {
		int randomTime = (int) (1 + Math.random() * (5 - 1 + 1));
		System.out.println("Count to " + randomTime + " seconds");
		// keeps time at the start of the game
		long start = System.currentTimeMillis();
		//System.out.println(start); //debug
		// scanner system that stops the timer
		System.out.print("Press Enter when you want to stop: ");
		Scanner stopTimer = new Scanner(System.in); 
		
		String userInput = stopTimer.nextLine(); // userInput doesn't matter,
		long timeDiff = 0;
		
		if (userInput != null) { // null so if user accidentally inputs text, the timer stops regardless
			long end = System.currentTimeMillis(); 
			timeDiff = Math.abs(end - start); // time it takes to click Enter 
			System.out.println("\nTook : " + (double) (timeDiff / 1000.0) + " seconds\n");
		}
		if (timeDiff > (((randomTime * 1000) - timeDiff) * 0.35)) {
			return true;
		} else {
			return false;
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


