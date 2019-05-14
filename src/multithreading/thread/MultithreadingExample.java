package multithreading.thread;

public class MultithreadingExample {

    public static void main(String[] args) {

        for (int i = 0; i < 8; i++) {
            ThreadDemo thread = new ThreadDemo();
            thread.start();
        }

    }

}
