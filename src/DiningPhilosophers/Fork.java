package DiningPhilosophers;

/**
 * Created by dennis on 9/14/2015.
 */
public class Fork {
    private int id;
    private boolean busy;

    Fork(int id){
        this.id = id;
        this.busy = false;
    }

    public boolean isBusy(){
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getId() {
        return id;
    }
}
