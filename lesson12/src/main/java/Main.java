import java.io.IOException;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Main {
    public static void main(String[] args) {
        try {
            SessionStarter.startSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
