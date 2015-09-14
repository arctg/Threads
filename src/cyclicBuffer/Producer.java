package cyclicBuffer;

/**
 * Created by dennis on 9/14/2015.
 */
public class Producer implements Runnable {

    CyclicBuffer cyclicBuffer;


    Producer(CyclicBuffer cyclicBuffer){
        this.cyclicBuffer=cyclicBuffer;
    }

    @Override
    public void run() {
        while (true){
            if (cyclicBuffer.isFull()){
                System.out.println("Buffer is full, waiting for consumer");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(Thread.currentThread().getName() + " put some item");
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                cyclicBuffer.add(new String("Some item"));
            }
        }
    }
}
