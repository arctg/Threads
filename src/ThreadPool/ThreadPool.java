package ThreadPool;

import java.util.LinkedList;

/**
 * Created by dennis on 9/4/2015.
 */
public class ThreadPool {

    private final int amount;
    private final PWorker[] threads;
    public final LinkedList goals;

    public ThreadPool(int num) {
        this.amount = num;
        goals = new LinkedList();
        threads = new PWorker[amount];

        for (int i = 0; i < amount; i++) {
            threads[i] = new PWorker();
            threads[i].start();
        }
    }

    public boolean haveWork() {
        return (goals.size() > 0) ? true : false;
    }

    public void execute(Runnable task) {
        synchronized (goals) {
            goals.addLast(task);
            goals.notify();
        }
    }

    private class PWorker extends Thread {
        public void run() {
            Runnable task;

            while (true) {
                synchronized (goals) {
                    while (goals.isEmpty()) {
                        try {
                            goals.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    task = (Runnable) goals.removeFirst();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                }
            }
        }
    }
}
