package DiningPhilosophers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 9/14/2015.
 */
public class Chef  {

    private static Map<Integer,Fork> forks = new HashMap<Integer,Fork>(){{
        put(1,new Fork(1));
        put(2,new Fork(2));
        put(3,new Fork(3));
        put(4,new Fork(4));
        put(5,new Fork(5));
    }};

    private boolean canUseFork(int forkId){
        return !forks.get(forkId).isBusy();
    }

    public Fork getLeftFork(int philosopherId){
        return getFork(philosopherId+1);
    }

    private Fork getFork(int forkId) {
        if(canUseFork(forkId)){
            forks.get(forkId).setBusy(true);
            return forks.get(forkId);
        }
        return null;
    }

    public Fork getRightFork(int philosopherId){
        if(philosopherId==0){
            return getFork(forks.size());
        }
        else{
            return getFork(philosopherId);
        }
    }


}
