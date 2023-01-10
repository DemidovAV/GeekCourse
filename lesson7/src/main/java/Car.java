import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int finishCounter = 0;
    private boolean winner = false;

    static {
        CARS_COUNT = 0;
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
            if (finishCounter == 0) {
                winner = true;
                finishCounter++;
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
