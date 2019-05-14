package multithreading.daemonthread;

public class DaemonPrinter {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            print(10000, '&');
            System.out.println("Job t1 is done");

        });

        Thread t2 = new Thread(() -> {
            print(10000, '€');
            System.out.println("Job t2 is done");
        });

        Thread t3 = new Thread(() -> {
            long interval = System.currentTimeMillis();
            while (true) {
                if ((System.currentTimeMillis() - interval) > 250) {
                    interval = System.currentTimeMillis();
                    System.out.println("\n\nDaemon is activated...\n");
                }
            }
        });

        // Add this to show daemon threads
        t3.setDaemon(true);


        // This is no way to know for sure that this works!!!
        startThreadcheckState(t1, Thread.MIN_PRIORITY);
        startThreadcheckState(t2, Thread.MIN_PRIORITY);
        startThreadcheckState(t3, Thread.MAX_PRIORITY);

    }


    private static void startThreadcheckState(Thread thread, int priority) {
        System.out.println(thread.getName() + ": " + thread.getState());
        thread.start();
        thread.setPriority(priority);
        System.out.println(thread.getName() + ": " + thread.getState());
    }

    private static void print(int count, char character) {
        for (int i = 0; i < count; i++) {
            System.out.print(character);
            Thread.yield();
        }
    }

}
