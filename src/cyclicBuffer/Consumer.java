package cyclicBuffer;

/**
 * Created by dennis on 9/14/2015.
 */
public class Consumer implements Runnable {

    CyclicBuffer cyclicBuffer;

    Consumer(CyclicBuffer cyclicBuffer){
        this.cyclicBuffer=cyclicBuffer;
    }

    @Override
    public void run() {
        while (true){
            if (cyclicBuffer.isEmpty()){
                System.out.println("Buffer is empty, waiting for Producer");
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " got " + cyclicBuffer.get().toString());
            }
        }
    }
}
