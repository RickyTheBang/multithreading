package multithreading.timertask;

import java.util.TimerTask;

public class TimeOut extends TimerTask {

    @Override
    public void run() {
        System.out.println("You ran out of time.");
    }

}
