package producerConsumer;

/**
 * Created by dennis on 9/8/2015.
 */
public class Consumer implements Runnable {

    private Bag bag;
    private Integer element;

    Consumer(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " has got " + bag.get());
        }
    }
}
