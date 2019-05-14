package exercises.multithreading_10;

import java.io.IOException;
import java.util.Timer;

public class ClockApp {
   public static void main(String[] args) throws IOException {
      Timer timer = new Timer(true);
      Clock clock = new Clock();
      timer.scheduleAtFixedRate(clock,0,1000);
      
      System.in.read();
   }
}
