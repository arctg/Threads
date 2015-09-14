package cyclicBuffer;

/**
 * Created by dennis on 9/11/2015.
 */
public class TestCyclicBuffer {

    public static void main(String args[]){
        CyclicBuffer<String> cyclicBuffer= new CyclicBuffer<>(5);

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());
        cyclicBuffer.add("A");

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());
        cyclicBuffer.add("B");

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());
        cyclicBuffer.add("C");

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());
        cyclicBuffer.add("D");

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());
        cyclicBuffer.add("E");

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());

        System.out.println("Get:" + cyclicBuffer.get().toString());

        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println("Full? " + cyclicBuffer.isFull());

        //cyclicBuffer.add("F");
        System.out.println(cyclicBuffer);
        //cyclicBuffer.add("G");
        System.out.println(cyclicBuffer.isFull());
        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println(cyclicBuffer);
        cyclicBuffer.add("H");
        System.out.println(cyclicBuffer.isFull());
        System.out.println("Empty? " + cyclicBuffer.isEmpty());
        System.out.println(cyclicBuffer);
        cyclicBuffer.add("1");
        System.out.println(cyclicBuffer);
        cyclicBuffer.add("2");
        System.out.println(cyclicBuffer);
        System.out.println(cyclicBuffer.isFull());
        cyclicBuffer.add("3");
        System.out.println(cyclicBuffer);
        cyclicBuffer.add("4");
        System.out.println(cyclicBuffer);
        cyclicBuffer.add("5");
        System.out.println(cyclicBuffer);

        //cyclicBuffer.get();

        for (int i=0;i<cyclicBuffer.getBufSize();i++){
            System.out.println("Get:" + cyclicBuffer.get().toString());
        }

        System.out.println("Empty? " + cyclicBuffer.isEmpty());

        System.out.println(cyclicBuffer);

        System.out.println(4%5);
        System.out.println(-1%5);

    }
}
