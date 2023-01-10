import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicInteger finishCounter;
    private boolean winner = false;

    static {
        CARS_COUNT = 0;
        finishCounter = new AtomicInteger(0);
    }
    private Race race;
    private int speed;
    private String name;

    private CyclicBarrier barrier;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "�������� #" + CARS_COUNT;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " ���������");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " �����");
            barrier.await();
            barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if (finishCounter.incrementAndGet() == 1) {
                winner = true;
            }
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public boolean isWinner() {
        return winner;
    }
}
