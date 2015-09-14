package calc;

import java.util.concurrent.Callable;

/**
 * Created by dennis on 9/11/2015.
 */
class MyThread implements Callable {
    boolean negative = true;
    double pi;

    public Double call() {
        for (int i = 3; i < 100000; i += 2) {
            if (negative)
                pi -= (1.0 / i);
            else
                pi += (1.0 / i);
            negative = !negative;
        }
        pi += 1.0;
        pi *= 4.0;
        System.out.println("Finished calculating PI");
        return pi;
    }
}
