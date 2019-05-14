package exercises.multithreading_06;

public class PrintAppLambda {
   public static void main(String[] args)
         throws InterruptedException {
      Thread thread1 = new Thread(() -> print('#', 100));
      Thread thread2 = new Thread(() -> print('*', 1000));
      thread1.setName("T1");
      thread2.setName("T2");
      thread1.start();
      thread2.start();

      thread1.join(3000);
      if (thread1.isAlive()) {
         thread1.interrupt();
         thread1.join(10);
      }

      thread2.join(3000);
      if (thread2.isAlive()) {
         thread2.interrupt();
         thread2.join(10);
      }

   }

   public static void print(char c, int count) {
      for (int i = 0; (i < count) && (!Thread.interrupted()); i++) {
         System.out.print(c);
         try {
            Thread.sleep(100);
         } catch (InterruptedException ex) {
            i = count;
         }
      }
   }
}
