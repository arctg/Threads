package bank; /**
 * Created by dennis on 9/9/2015.
 */

import java.util.Random;

public class Randoma {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
