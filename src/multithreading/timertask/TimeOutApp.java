package multithreading.timertask;

import java.util.Timer;

public class TimeOutApp {

    public static void main(String[] args) {

        TimeOut task = new TimeOut();
        Timer timer = new Timer(true);

        timer.schedule(task, 1000 * 10);

        System.out.println("Please wait a moment.");
        try {
            Thread.sleep(1000 * 20);  // Play with this line [lose the * 20 part to show timer not starting.]
        } catch (InterruptedException e) {
            System.out.println("Thread [" + Thread.currentThread().getId() + "]: is Interrupted.");
        }

        System.out.println("End of the program.");
    }

}
