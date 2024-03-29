import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Lesson7Main {
    public static final int CARS_COUNT = 6;
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
        System.out.println("������ ���������� >>> ����������!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cb.await();
            System.out.println("������ ���������� >>> ����� ��������!!!");
            cb.await();
            cb.await();
            System.out.println("������ ���������� >>> ����� �����������!!!");
            for (Car contestant: cars) {
                if(contestant.isWinner()) {
                    System.out.println("����������: " + contestant.getName());
                }
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

