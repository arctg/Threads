package cyclicBuffer;

/**
 * Created by dennis on 9/11/2015.
 */
public class CyclicBuffer<T> {


    private T[] buffer;

    private Integer size;

    private int head;
    private int tail;
    private int bufSize;

    CyclicBuffer(Integer size) {
        this.buffer = (T[]) new Object[size];
        this.head = 0;
        this.tail = 0;
        this.bufSize = 0;
    }

    public  void add(T item) {
        synchronized (buffer) {
            if (!isFull()) {
                bufSize++;
                buffer[tail] = item;
                tail = (tail + 1) % buffer.length;
                buffer.notify();

            } else {
                try{
                    wait(5000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }

    public  T get() {
        synchronized (buffer) {
            if (!isEmpty()) {
                bufSize--;
                T value = buffer[head];
                head = (head + 1) % buffer.length;
                buffer.notify();
                return value;
            } else {
                try{
                    wait(5000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
            //System.out.println("Can't get element, buffer is empty");
            return null;
        }
    }

    public  boolean isFull() {
//        if (head - 1 == tail) {
//            return true;
//        }
//        if ((tail == buffer.length - 1) && head == 0) {
//            return true;
//        }
        synchronized (buffer) {
            return bufSize == buffer.length;
        }
    }

    public synchronized boolean isEmpty() {
        return bufSize==0;
    }


    public int getBufSize(){
        return buffer.length;
    }

    @Override
    public String toString() {
        StringBuffer stringToOut = new StringBuffer();
        for (int i = 0; i < buffer.length; i++) {
            stringToOut.append(buffer[i]);
            stringToOut.append(" ");
        }
        return stringToOut.toString();
    }


}
