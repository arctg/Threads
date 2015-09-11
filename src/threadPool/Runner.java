package threadPool;

/**
 * Created by dennis on 9/10/2015.
 */
public class Runner {

    public static void main(String args []){
        ThreadPool threadPool = new ThreadPool(10);
        Integer  number = 0;
        for (int i=0;i<200;i++){
            threadPool.execute(new Task("" + i));
        }
    }
}

