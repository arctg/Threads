package calc;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by dennis on 9/11/2015.
 */
public class FJCounter extends RecursiveTask<Integer> {


    public static final int THRESHHOLD = 5;
    private int[] numbers;
    private int from;
    private int to;

    FJCounter(int[] numbers) {
        this(numbers, 0, numbers.length);
    }

    FJCounter(int[] numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }


    public int calc() {
        int max = 0;
        for (int x = from; x < to; x++) {
            max = numbers[x];
        }
        return max;
    }


    public int problemSize() {
        return this.to - this.from;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHHOLD) {
            return calc();
        }

        int split = (to - from) / 2;
        FJCounter left = new FJCounter(numbers, from, from + split);
        FJCounter right = new FJCounter(numbers, from + split, to);

        right.fork(); //???????? ??????????? ? ?????? ??????

        left.compute();

        return Math.max(left.join(), right.compute());


    }
}
