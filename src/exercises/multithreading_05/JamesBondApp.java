package exercises.multithreading_05;

import java.util.*;

public class JamesBondApp {
   public static void main(String[] args) throws InterruptedException  {
      Random rand = new Random();        // Some random number 
      TimeBomb bomb = new TimeBomb(10);  // Bom with 10 seconds time
      bomb.activate();                   // Bom activated by bad guy
      Thread.sleep(rand.nextInt(30000)); // sleep with the enemy      
      bomb.disarm();                     // 007 disarms boomb
   }
}
