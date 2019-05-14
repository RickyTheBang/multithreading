package multithreading.objectlocking;

/**
 * Created by Mrrobot on 11/06/2018 javabasics-workspace.
 */
public class PingPongApp {

    public static void main (String[] args) {

        StringPrinter ping = new StringPrinter(10, "ping");
        StringPrinter pong = new StringPrinter(10, "pong");

        Object monitor = new Object();

        ping.setMonitor(monitor);
        pong.setMonitor(monitor);

        Thread t1 = new Thread(ping, "ping");
        Thread t2 = new Thread(pong, "pong");

        t1.start();
        t2.start();

    }
}
