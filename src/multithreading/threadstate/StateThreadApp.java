package multithreading.threadstate;

public class StateThreadApp {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> print('#', 10_000));
        Thread thread2 = new Thread(() -> print('*', 10_000));

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

        thread1.start();
        System.out.println(thread1.getState());
        thread2.start();
        System.out.println(thread2.getState());
    }

    private static void print(char c, int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%nTime it took thread[id:%s] %dms.", Thread.currentThread().getId() ,(endTime - startTime));
    }

}
