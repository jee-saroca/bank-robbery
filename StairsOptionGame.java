import java.util.Scanner;

public class StairsOptionGame {
    public static void main(String[] args) {
        Scanner charReader = new Scanner(System.in);
        
        delaySpeech(500); 
        System.out.println("Alright!");
        delaySpeech(1250); 
        System.out.println("Let's get moving.");
        delaySpeech(1000);
        slowType("Hold on. Let me check ...\nDamn!\nThey activated an alarm", 120);
        delaySpeech(1250); 
        slowType("Okay...Okay...\nShut\nIt\nDown\nNow!!!\n", 150);
        
        // Array holding strings for hang-man type game.
        String[] gameWords = {"Laundrette", "Flukas", "Dreams", "Thief",
                              "Autumn", "Afternoon", "Human", "Condition",
                              "Loser", "Game", "Cat", "Computer", "Liang",
                              "Chips", "Seven", "Granola"};
        
        boolean gameInProgress = true;
        String randomWord;
        int addedTries = 0;
        
        int intellect = 0; // Delete this when integrated to main game
        
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
            if (intellect == 4) {
                addedTries += 2;
                revealCharacters(wordHidden, randomWord, addedTries);
            } else if (intellect == 2) {
                addedTries += 1;
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
                }
                if (attempts > 0) {
                    userGuess = charReader.next().charAt(0);
                }
            }

            gameInProgress = false; // Ends game
        }
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
        
    //Delays when speech comes out
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




           
