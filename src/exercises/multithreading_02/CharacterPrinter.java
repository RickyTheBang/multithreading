package exercises.multithreading_02;

public class CharacterPrinter implements Runnable {
   private char c;
   private int count;

   public CharacterPrinter(char c, int count)   {
      this.c = c;
      this.count = count;
   }

   public void run() {
      for(int i = 0 ; i< count; i++) {
       System.out.print(c);
      }
   }
}