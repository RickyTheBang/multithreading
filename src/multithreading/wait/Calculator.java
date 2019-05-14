package multithreading.wait;
/*
Alle methoden in deze klasse zijn gesynchroniseerd.
Dit zorgt ervoor dat er maar 1 thread actief kan zijn in deze klasse.

Indien een thread moet wachten tot wanneer een andere thread de methode getResult gebruikt heeft,
word die in een wachttoestand geplaatst met de methode wait().
 */
public class Calculator {

    private int value = 0;
    private int result = 0;

    private boolean done = true;
    private boolean busy = false;

    private Thread t;

    public Calculator() {
        Thread thread = new Thread(() -> calculate());
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void setValue(int value) {
        while (busy) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
            }
        }
        System.out.println(Thread.currentThread().getName() + ": set the value " + value);
        this.value = value;
        done = false;
        busy = true;
        notifyAll();
    }

    public synchronized int getResult() {
        while (!done) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
            }
        }
        busy = false;
        System.out.println(Thread.currentThread().getName() + ": gets the result");
        notifyAll();
        return result;
    }

    private synchronized void calculate() {
        while (true) {
            while (done) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
            System.out.println(Thread.currentThread().getName() + ": calculates the result");
            result = value * value;
            done = true;
            notifyAll();
        }
    }

}
