// Timer from start of the game to the end. Will turn into method if story can end in different ways.

import java.util.Scanner;

public class Timer{
    public static void main(String[]args){
        
        long startTime = System.currentTimeMillis();
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter \"Q\" whenever"); // Replace in final product
                         
        String input = userInput.nextLine();
        
        if(input.equalsIgnoreCase("Q")){
            long endTime = System.currentTimeMillis();
            long testTime = endTime - startTime;
                if((testTime * 0.001) / 60 < 1 ){
                    System.out.printf("Program ran for: %.2f seconds.", testTime * 0.001);
                }else{
                    long minutes = (testTime / 1000) / 60;
                    long seconds = (testTime / 1000) % 60;
                    System.out.println( "Program ran for: "
                                      + minutes + " minutes, and "
                                      + seconds + " seconds.");
                }    
        }
            
        userInput.close();
    }
}