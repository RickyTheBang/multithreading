package multithreading.objectlocking.demo2;

/**
 * Created by Mrrobot on 11/06/2018 javabasics-workspace.
 */

/*
Class that prints a string value

first without comments

Then add them to sync the 2 threads
Use 2 different objects to monitor then change it to 1 object
 */
public class StringPrinter implements Runnable {

    private int count;
    private String value;

    private Object monitor;


    public StringPrinter(int count, String value) {
        super();
        this.count = count;
        this.value = value;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int x = 0; x <= count; x++) {
            synchronized (monitor) {
                monitor.notifyAll();
                System.out.println(value);
                try {
                    monitor.wait();
                    if (x == count) {
                        System.exit(1);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Oops: " + e.getMessage());
                }
            }
        }
    }
}
