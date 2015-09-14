package cyclicBuffer;

/**
 * Created by dennis on 9/14/2015.
 */
public class TestProdConsBuff {
    public static void main(String args[]){

        CyclicBuffer<String> cyclicBuffer = new CyclicBuffer<>(5);

        new Thread(new Producer(cyclicBuffer)).start();
        new Thread(new Producer(cyclicBuffer)).start();
        new Thread(new Consumer(cyclicBuffer)).start();
    }
}
