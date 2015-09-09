package ProducerConsumer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Runner {


    public static void main(String[] args) {

        Bag bag = new Bag();
        Consumer consumer = new Consumer(bag);
        Producer producer = new Producer(bag,5);

        //
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
