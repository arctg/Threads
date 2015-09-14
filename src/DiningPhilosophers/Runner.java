package DiningPhilosophers;

/**
 * Created by dennis on 9/14/2015.
 */
public class Runner {

    public static void main(String args []){

        for (int i=0;i<5;i++){
            new Thread(new Philosoper()).start();
        }

    }
}
