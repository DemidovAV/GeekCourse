import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Main {
    public static void main(String[] args) {
        try {
            SessionOperations.startSession();
            CyclicBarrier cb = new CyclicBarrier(9);
            for (int i = 0; i < 8; i++) {
                System.out.println("Запуск потока №" + (i+1));
                new Thread(new MyStream(cb)).start();
            }
            cb.await();
            SessionOperations.countValSum();
        } catch (IOException | InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
