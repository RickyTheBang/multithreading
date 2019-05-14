package multithreading.join;

public class JoinApp {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> print('#', 100));
        Thread thread2 = new Thread(() -> print('*', 1000));

        thread1.start();
        thread2.start();

        /*
        NOTE that thread1.join and thread2.join did not do anything to thread thread1 or to thread thread2.
        It only affected the thread that called it (i.e., the main() thread).

        The main will be in a timed waiting untill both threads are in a TerminatedStatus.
         */
        thread1.join();
        thread2.join();

        System.out.println("End of the main!");
    }

    private static void print(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId() + " :Interrupted");
            }
        }
    }

}
