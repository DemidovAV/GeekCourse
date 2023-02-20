import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyStream  implements Runnable {

    private CyclicBarrier cb;

    public MyStream(CyclicBarrier cb) {
        this.cb = cb;
    }

    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    @Override
    public void run() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            for (int i = 0; i < 20000; i++) {
                session = factory.getCurrentSession();
                session.beginTransaction();
                Item item = (Item) session.createQuery("FROM Item WHERE id = :id")
                        .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                        .setParameter("id", rnd(1, 40)).getSingleResult();
                item.setVal(item.getVal() + 1);
                session.save(item);
                Thread.sleep(5);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if(session != null) {
                session.close();
            }
        }
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
