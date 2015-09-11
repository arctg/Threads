package producerConsumer;

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
