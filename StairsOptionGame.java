// New code, still have to add different difficulty levels.
// have to add different dialog options when user gets password wrong or right

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
        slowType("Okay...Okay...\nShut\nIt\nDown\nNow!!!", 150);
        
        // Array holding strings for hang-man type game.
        String[] gameWords = {"Laundrette","Flukas","Dreams","Thief",
                              "Autumn","Afternoon","Human","Condition"};
        
        boolean gameInProgress = true;
        String randomWord;
        
        // Gameloop: Code for HangMan Like game. 
        while (gameInProgress) {
            randomWord = gameWords[(int)(Math.random() * gameWords.length)];
            String wordHidden = "";

            // Makes the random word picked from array into all *
            for(int i = 0; i < randomWord.length(); i++) {
                wordHidden += "*";
            }

            System.out.println(wordHidden);

            delaySpeech(1000);
            slowType("It looks like we need to guess the letter to form a word.", 100);
            char userGuess = charReader.next().charAt(0);

            int attempts = randomWord.length() * 2; // Maximum number of attempts

            //  This loop allows game to go through many attempts
            while (attempts > 0) {
                if (randomWord.indexOf(userGuess) != -1) {
                // Correct guess: Update wordHidden
                    for (int i = 0; i < randomWord.length(); i++) {
                        if (randomWord.charAt(i) == userGuess) {
                            wordHidden = wordHidden.substring(0, i) + userGuess 
                                         + wordHidden.substring(i + 1);
                        }
                    }
                    System.out.println("That looks good, keep going!");
                    System.out.println(wordHidden);
                } else {
                    System.out.println("Hmm, dont think thats right, keep trying");
                }
                attempts--; // Decrement attempts
                
                if (wordHidden.equals(randomWord)) {
                    // All letters guessed correctly, break out of the loop
                    System.out.println("Alright We got it! Let's get out of here");
                    break;
                }
                if (attempts > 0) {
                    // Need to add different phrases from characters here
                    slowType("Keep trying man!", 100);
                    userGuess = charReader.next().charAt(0);
                }
            }   

            gameInProgress = false; // Ends game
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



/* Old code
// Not finished, have to add loop so user can actually guess complete word
// Also have to add a counter that only allows users to get 10 tries or so

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
        slowType("Okay...Okay...\nShut\nIt\nDown\nNow!!!", 150);
        
        String[] gameWords = {"Laundrette","Flukas","Dreams","Thief",
                              "Autumn","Afternoon","Human","Condition"};
        
        boolean gameInProgress = true;
        String randomWord;
        int randomIndexWordGame = (int)(Math.random() * gameWords.length);
        
        while(gameInProgress){
            randomWord = gameWords[randomIndexWordGame];
            System.out.println(randomWord);
            String wordHidden = "";
            
            for(int i = 0; i < randomWord.length(); i++){
                wordHidden += "*";
            }
            
            System.out.println(wordHidden);
            
            delaySpeech(1000);
            slowType("It looks like we need to guess a word", 100);
            char userGuess = charReader.next().charAt(0);
            
            if (randomWord.indexOf(userGuess) != -1) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == userGuess) {
                        wordHidden = wordHidden.substring(0, i) + userGuess + wordHidden.substring(i + 1);
                    }
                }
                System.out.println("Correct guess!");
                System.out.println(wordHidden);
            } else {
                System.out.println("Incorrect guess!");
            // Update lives counter or provide other feedback here
            }

            
            if(randomWord.contains(userGuess)){
                int userIndex = randomWord.indexOf(userGuess);
                wordHidden = wordHidden.substring(0, userIndex) + userGuess +         wordHidden.substring(userIndex + 1);
                System.out.println(userIndex);
                //wordHidden2 = wo
            }
            
            gameInProgress = false;
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
*/




           
