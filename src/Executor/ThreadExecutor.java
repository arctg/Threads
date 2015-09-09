package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 9/9/2015.
 */
public class ThreadExecutor {
    public static void main(String args[]){
        ExecutorService executor = new ThreadPoolExecutor(
                5, //core pool size
                10, // max pool size
                100L, // keep alive
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(30), //queue
                new ThreadPoolExecutor.CallerRunsPolicy() //strategy
        );

        System.out.println("Main thread id " + Thread.currentThread().getId());

    }
}
