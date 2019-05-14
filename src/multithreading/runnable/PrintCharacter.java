package multithreading.runnable;

/**
 * Created by Mrrobot on 7/06/2018 javabasics-workspace.
 */
public class PrintCharacter implements Runnable {
                                        // ctrl + right click it

    private int counter;
    private char c;

    public PrintCharacter(int counter, char c){
        this.c = c;
        this.counter = counter;
    }

    /*
    Just like in the previous example we need
    to overwrite the method run and give our
    statements to execute in here
     */
    @Override
    public void run () {
        for (int i = 0; i <= counter; i++) {
            System.out.print(c);
        }
    }

    //Just like in previous example
    public static void main (String[] args) {

        PrintCharacter printCharStar = new PrintCharacter(100, '*');
        PrintCharacter printCharHashtag = new PrintCharacter(100, '#');
        PrintCharacter printCharDollar = new PrintCharacter(100, '$');

        Thread thread1 = new Thread(printCharStar);
        Thread thread2 = new Thread(printCharHashtag);
        Thread thread3 = new Thread(printCharDollar);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
