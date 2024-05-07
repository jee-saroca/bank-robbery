// Little HAcking animation 
public class HackAnimation {
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    
    public static void main(String[] args) {
        for (int i = 35; i >= 0; i--) {
            //System.out.println("\f\n");
            System.out.print("\r"); // Move cursor to the beginning of the line
            System.out.print(green((int)(Math.random() * 10) + "\t"));  
            System.out.print(green((int)(Math.random() * 10) + "\t"));
            System.out.print(green((int)(Math.random() * 10) + "\t"));
            System.out.print(green((int)(Math.random() * 10) + "\t"));
            System.out.print(green((int)(Math.random() * 10) + "\t"));
            delaySpeech(100);
        }
        //delaySpeech(100);
        //System.out.println("\f\f\f\f\f\f\f\f\f\f\f"); 
        //Add above line 18 and 8, if you want more than one line of animation
        
    }
    
    public static String green(String s) {
        return GREEN + s + RESET;
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

}

/*
Can use \b which can erase chracters, maybe put in for loop, maybe \r
*/