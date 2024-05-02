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

            /*
            if(randomWord.contains(userGuess)){
                int userIndex = randomWord.indexOf(userGuess);
                wordHidden = wordHidden.substring(0, userIndex) + userGuess +         wordHidden.substring(userIndex + 1);
                System.out.println(userIndex);
                //wordHidden2 = wo
            }*/
            
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



/*
STAIRS (-0% money)
        PARTNER: "Alright! Let's get out of here."
        Before you take a step outside the vault, your partner stops you
        PARTNER: "Hold it. Let me check something"
        He whips out his tablet.
        PARTNER: "They activated their silent alarm"
        *Partner's intellect stat* -- the better the intelligence, the easier the code.
        PARTNER: "We have to hack in, help me solve it."
        Game:
            *Maybe we can make an array with different word combinations that someone has to unscramble*
        PARTNER: "Nice! Let's get out of here"
        Both of you make it out the back door of the building.
        "Hey what are you two doing here"
        You turn around to see two guards looking at you from the door. */