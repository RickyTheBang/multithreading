package multithreading.lambda;

/**
 * Created by Mrrobot on 7/06/2018 javabasics-workspace.
 */
public class LambdaPrinter {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            print(100, '*');
            System.out.println("Job t1 is done");

        });

        Thread t2 = new Thread(() -> {
            print(100, '#');
            System.out.println("Job t2 is done");
        });

        t1.start();
        t2.start();

    }

    private static void print(int count, char character) {
        for (int i = 0; i <= count; i++) {
            System.out.print(character);
        }
    }

}
