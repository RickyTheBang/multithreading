package exercises.multithreading_03;

public class PrintApp {
   public static void main(String[] args) throws Exception {
      PrintThread myThread1 = new PrintThread('*', 1000);
      PrintThread myThread2 = new PrintThread('#', 1000);
      myThread1.start();
      myThread2.start();
   }

}
