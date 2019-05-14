package exercises.multithreading_03;

public class PrintAppLambda {
   public static void main(String[] args) {
      System.out.println(Runtime.getRuntime().availableProcessors());
      Thread thread1 = new Thread(() -> print('#', 1000));
      Thread thread2 = new Thread(() -> print('*', 1000));
      thread1.start();
      thread2.start();
      
   }

   public static void print(char c, int count) {
      for (int i = 0; i < count; i++) {
         System.out.print(c);
         Thread.yield();
      }
   }
}
