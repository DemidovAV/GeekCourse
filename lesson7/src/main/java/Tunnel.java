import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore smp = new Semaphore(Lesson7Main.CARS_COUNT/2);
    public Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                if (!smp.tryAcquire()) {
                    System.out.println(c.getName() + " ��������� � �����(����): " + description);
                    smp.acquire();
                }
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " �������� ����: " + description);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

