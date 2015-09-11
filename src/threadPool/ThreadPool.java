package threadPool;

import java.util.LinkedList;

/**
 * Created by dennis on 9/4/2015.
 */
public class ThreadPool {

    private final int amount;
    private final PWorker[] threads;
    public final LinkedList tasks;

    public ThreadPool(int num) {
        this.amount = num;
        tasks = new LinkedList();
        threads = new PWorker[amount];

        for (int i = 0; i < amount; i++) {
            threads[i] = new PWorker();
            threads[i].start();
        }
    }

    public boolean haveWork() {
        return (tasks.size() > 0) ? true : false;
    }

    public void execute(Runnable task) {
        synchronized (tasks) {
            tasks.addLast(task);
            tasks.notify();
        }
    }

    private class PWorker extends Thread {
        public void run() {
            Runnable task;

            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    task = (Runnable) tasks.removeFirst();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                }
            }
        }
    }
}
