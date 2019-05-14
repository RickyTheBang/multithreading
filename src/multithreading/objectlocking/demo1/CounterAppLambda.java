package multithreading.objectlocking.demo2;

public class CounterAppLambda {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> increment(counter, 10_000));
        Thread thread2 = new Thread(() -> increment(counter, 10_000));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }

    private static void increment(Counter counter, int iter) {
        for (int i = 0; i < iter; i++) {
            counter.increment();

        }
    }

}
