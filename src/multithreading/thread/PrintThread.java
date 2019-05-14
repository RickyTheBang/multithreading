package multithreading.thread;

/**
 * Created by Mrrobot on 7/06/2018 javabasics-workspace.
 */

/*
This class is written so that you can
see the impact that multithreading has.
 */
public class PrintThread extends Thread {  //we are using Thread so that we can overwrite run method

    /*
    Fields will be used to print a certain character ? times
     */
    private char c;
    private int count;

    public PrintThread(char c, int count) {
        this.c = c;
        this.count = count;
    }

    /*
    Just like in a main method here we program
    the statements that we want to execute[run]
     */
    @Override
    public void run () {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
    }

    // Let's be lazy and make our main here
    public static void main (String[] args) {

        // You can make as much as you want
        PrintThread p = new PrintThread('*', 50);
        PrintThread p2 = new PrintThread('#', 50);

        // We can start our threads by calling the start method
        p.start();
        p2.start();

    }
}
