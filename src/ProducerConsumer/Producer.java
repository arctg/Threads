package ProducerConsumer;

import java.io.IOException;

/**
 * Created by dennis on 9/8/2015.
 */
public class Producer implements Runnable {

    private Bag bag;
    private Integer element;

    Producer(Bag bag, Integer element) {
        this.bag = bag;
        this.element = element;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bag.put(element);
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

            } catch (IOException e) {
                System.out.println(Thread.currentThread().getName() + "can't put the element");
            }
        }
    }
}
