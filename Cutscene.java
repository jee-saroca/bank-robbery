//Version of cutscene, not using thread.sleep()
//Spent too much time on this :|

public class Cutscene {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long interval = 250; // Interval in milliseconds
        long duration = 1500; // Duration in milliseconds

        int jam = 0;
        boolean stop = true;
        String[] film = new String[6];
        film[0]  = "-------\n"+
                   "0      \n"+
                   "_______"  ;
        
        film[1]  = "-------\n"+
                   " 0     \n"+
                   "_______"  ; 
        
        film[2]  = "-------\n"+
                   "  0    \n"+
                   "_______"  ; 
        
        film[3]  = "-------\n"+
                   "   0   \n"+
                   "_______"  ; 
        
        film[4]  = "-------\n"+
                   "    0  \n"+
                   "_______"  ; 
        
        film[5]  = "-------\n"+
                   "     0 \n"+
                   "_______"  ; 

        while (stop) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            if (elapsedTime >= duration) {
                System.out.println("Printing stopped after 1.5 seconds.");
                stop = false;
                break;
            } else if (elapsedTime >= interval * jam) {
                System.out.println(film[jam]);
                jam++;
            }
        }
    }
}


/*
public class Cutscene {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long interval = 500; 
        long duration = 2000; 
        
        int jam = 0;
        boolean stop = true;
        
        while (stop) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            
            if (jam == 6) {
                System.out.println("Printing stopped after 2 seconds.");
                stop = false;
                break; 
            }
            
            else if (elapsedTime >= interval) {
                System.out.println("Printed at: " + (currentTime / 1000) % 60);
                jam += 1;
                startTime = currentTime;
            }
        }
    }
}*/