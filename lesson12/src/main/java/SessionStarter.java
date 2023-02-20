import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SessionStarter {

    public static void startSession() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("StartingScript.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
            for(int i = 0; i < 40; i++) {
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
}
