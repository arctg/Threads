package concurrent;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dennis on 9/9/2015.
 */
public class BigInt extends AtomicReference<BigInteger> {

    private BigInteger value;

    BigInt(Integer value){
        super(BigInteger.valueOf(value));


    }

    public BigInteger next() {
        for (; ; ) {
            BigInteger val = get();
            val = val.multiply(BigInteger.valueOf(2));
            if (compareAndSet(get(), val)) return get();

        }
    }

    public static void main(String args []){
        BigInt bigInt = new BigInt(1);

        for (int i=0;i<10;i++){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(bigInt.next());
            }
        });
        thread.start();}


    }
}
