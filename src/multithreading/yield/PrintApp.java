package multithreading.yield;

public class PrintApp {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> print('#', 420));
        Thread thread2 = new Thread(() -> print('@', 420));
        Thread thread3 = new Thread(() -> print('*', 420));

        thread1.start();
        thread2.start();
        thread3.start();

    }

    private static void print(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
//            Thread.yield();
        }
    }

}
