package exercises.multithreading_12;

import java.util.*;
import java.util.concurrent.*;

public class PrimeApp {

   public static void main(String[] args) throws Exception {
      PrimeCalculator pc = new PrimeCalculator(10000000);
      
      ExecutorService es = Executors.newSingleThreadExecutor();
      
      Future<List<Long>> future = es.submit(pc);      
      
      while(!future.isDone()) {
         System.out.println("Waiting");
      }
      
      List<Long> primes = future.get();
      
      
      for(long p: primes) {
         System.out.println(p);
      }
      es.shutdown();
      
   }

}
