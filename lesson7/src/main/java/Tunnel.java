import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore smp;
    public Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
        this.smp = new Semaphore(Lesson7Main.CARS_COUNT/2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " ��������� � �����(����): " +
                        description);
                smp.acquire();
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " �������� ����: " +
                        description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

