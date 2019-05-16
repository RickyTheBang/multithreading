package multithreading.timertask;

import java.util.Timer;

public class TimeOutApp {

    public static void main(String[] args) {

        TimeOut task = new TimeOut();
        Timer timer = new Timer(true);

        timer.schedule(task, 10_000);

        System.out.println("Please wait a moment.");
        try {
            Thread.sleep(20_000);  // Play with this line.
        } catch (InterruptedException e) {
            System.out.println("Thread [" + Thread.currentThread().getId() + "]: is Interrupted.");
        }

        System.out.println("End of the program.");
    }

}
