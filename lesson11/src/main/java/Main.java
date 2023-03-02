import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.annotations.Cascade;
import javax.persistence.Query;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            sessionManager.startSession();
            sessionManager.startDBManagement();

        } finally {
            sessionManager.stopSession();
        }
    }

}
