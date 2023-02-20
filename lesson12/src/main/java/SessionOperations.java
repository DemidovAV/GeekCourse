import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SessionOperations {

    public static void startSession() throws IOException {
        System.out.println("Подготовка таблицы items");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("D:\\For java\\GeekCourses\\lesson12\\src\\main\\java\\starting-script.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
            for(int i = 0; i < 40; i++) {
                session = factory.getCurrentSession();
                session.beginTransaction();
                Item item = new Item();
                item.setVal(0);
                session.save(item);
                session.getTransaction().commit();
            }
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void countValSum() {
        System.out.println("counting sum of 'val':");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Long sum = (Long) session.createQuery("SELECT sum(val) FROM Item").getResultList().get(0);
            System.out.println("Sum of 'val' column in table 'items' is " + sum);
            session.getTransaction().commit();
        } finally {
            factory.close();
            if(session != null) {
                session.close();
            }
        }
    }
}
