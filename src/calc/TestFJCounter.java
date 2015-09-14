package calc;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by dennis on 9/11/2015.
 */
public class TestFJCounter {

    public final static  int SIZE = 10000;


    public static void main(String args []){


        final int[] numbers = new int[SIZE];
        int maxNum = 0;
        long st = System.currentTimeMillis();

        for(int i=0;i<SIZE;i++){
            numbers[i] = (int)(Math.random()*10000);
            if (numbers[i]>maxNum){
                maxNum = numbers[i];
            }
        }

        System.out.println("Max num: " + maxNum + " calculated by " + (System.currentTimeMillis()-st));

        long pt = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        FJCounter fjCounter = new FJCounter(numbers);
        System.out.println("Max num " + forkJoinPool.invoke(fjCounter) + " calculated by " + (System.currentTimeMillis()-pt));
    }

}
