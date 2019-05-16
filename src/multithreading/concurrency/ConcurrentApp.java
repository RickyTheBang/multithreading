package multithreading.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentApp {

    public static void main(String[] args) {

        List<Integer>  list = new ArrayList<>();
        List<Integer>  secList = new ArrayList<>();


        List<Integer> sList = Collections.synchronizedList(secList);

        Thread t1 = new Thread(() -> populate(list, 100));
        Thread t2 = new Thread(() -> populate(list, 100));

        Thread t3 = new Thread(() -> populate(sList, 100));
        Thread t4 = new Thread(() -> populate(sList, 100));


//        t1.start();
//        t2.start();

        t3.start();
        t4.start();

        try {
//            t1.join();
//            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while calling join: "
                    + e.getMessage());
        }

//        System.out.println("List has a size of: " + list.size());
        System.out.println("List has a size of: " + sList.size());
        System.out.println("End of main...");
    }

    private static void populate(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

}
