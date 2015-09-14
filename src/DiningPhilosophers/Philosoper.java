package DiningPhilosophers;

/**
 * Created by dennis on 9/14/2015.
 */
public class Philosoper implements Runnable {
    private static final int THINKING_TIME = 3000;
    private static final int EATING_TIME = 1500;
    private static int philosofersCount = 0;

    private int id;

    private Fork leftFork, rightFork;

    private Chef chef = new Chef();

    public Philosoper() {
        this.id = philosofersCount;
        philosofersCount++;
    }

    private void takeLeftFork() {
        if (leftFork == null) {
            leftFork = chef.getLeftFork(id);
        }
    }

    private void takeRightFork() {
        if (rightFork == null) {
            rightFork = chef.getRightFork(id);
        }
    }

    private void eat() throws InterruptedException {
        takeLeftFork();
        takeRightFork();
        if (bothForksAvaliable()) {
            System.out.println("Both forks " + leftFork.getId() + " and " + rightFork.getId() + " are available for using by philosopher " + id);
            System.out.println("Philosopher with id: " + id + " has started eating");
            waitFor(EATING_TIME);
            System.out.println("Philosopher with id: " + id + " has finished eating");
            putDownBothForks();
        } else {
            putDownBothForks();
            System.out.println("Philosopher with id: " + id +" There are no free forks:( Thinking...");
            waitFor(THINKING_TIME);
        }
    }

    private void putDownBothForks() {
        if(null!=rightFork) {
            rightFork.setBusy(false);
        }
        if(null!=leftFork){
            leftFork.setBusy(false);
        }
        leftFork = null;
        rightFork =null;
    }

    private void waitFor(int timeInMilliseconds) throws InterruptedException {
        Thread.currentThread().sleep(timeInMilliseconds);
    }
    private void think() throws InterruptedException {
        waitFor(THINKING_TIME);
    }

    private boolean bothForksAvaliable() {
        return leftFork != null && rightFork != null;
    }

    @Override
    public void run() {
        System.out.println("Thread for philosopher " + id + " has started");
        while (true){
            try {
                eat();
                think();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }

    }
}
