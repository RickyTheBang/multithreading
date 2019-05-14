package multithreading.sleep;

public class PrintAppLambda {
    public static void main(String[] args){

        Thread thread1 = new Thread(() -> print('#', 100));
        Thread thread2 = new Thread(() -> print('*', 100));

        thread1.setName("T1");
        thread2.setName("T2");

        thread1.start();
        thread2.start();


        while (true) {
            thread1.interrupt();
            thread2.interrupt();
            if(!thread1.isAlive() && !thread2.isAlive()) {
                System.exit(1);
            }
        }

    }

    private static void print(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState());
            System.out.print(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println();
                System.out.print(Thread.currentThread().getName() + " :Interrupted");
                System.out.println();
            }
        }
    }

}
