package SyncSingleton;

/**
 * Created by dennis on 9/4/2015.
 */
public class Singleton {
    private static volatile Singleton instance;

    Singleton() {
    }

    public static  Object getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
