package threadPool;

/**
 * Created by dennis on 9/10/2015.
 */
public class Task implements Runnable {

    private String command;

    public Task(String command) {
        this.command = command;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts. Command is " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " ends");
    }

    public void processCommand() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public String toString() {
        return this.command;
    }
}
