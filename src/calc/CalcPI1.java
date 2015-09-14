package calc;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by dennis on 9/11/2015.
 */
class CalcPI1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

//        ExecutorService executor = new ThreadPoolExecutor(
//                5, //core pool size
//                5, // max pool size
//                100L, // keep alive
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(30), //queue
//                new ThreadPoolExecutor.CallerRunsPolicy() //strategy
//        );
        ExecutorService executor = new ForkJoinPool(5);

        List<Future> futureList;
        Future<Double> doubleFuture[] = new Future[5];
        for (int i = 0; i < 5; i++) {
            doubleFuture[i] = executor.submit(new MyThread());
        }

        Double sum = 0.0;

        for (int i = 0; i < 5; i++) {
            try {
                sum += doubleFuture[i].get();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(sum);


    }
}
