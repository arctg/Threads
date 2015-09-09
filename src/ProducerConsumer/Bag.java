package ProducerConsumer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dennis on 9/8/2015.
 */
public class Bag {

    private List<Integer> set = new ArrayList<>();

    public void put(Integer element) throws IOException {
        synchronized (set) {
            if (set.size() > 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting by attempt to put");
                    set.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                throw new IOException("This bag is not empty!");
            } else {
                System.out.println(Thread.currentThread().getName() + " is putting the element");
                set.add(element);
                set.notify();
            }
        }


    }

    public  Integer get() {
        synchronized (set) {
            try {
                if (set.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + ": There is nothing in the bag, waiting for pruducer!");
                    set.wait();
                    //wait();
                } else {

                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            Integer element = set.get(0);
            set.clear();
            System.out.println("Size is: " + set.size());
            set.notify();
        //notify();
            return element;
        }
    }

    public synchronized Integer size() {
        return set.size();
    }
}
