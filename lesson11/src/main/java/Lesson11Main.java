import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Lesson11Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        Session session = null;
        Map<String, Integer> products = new HashMap<>();
        products.put("MP3_Player", 5600);
        products.put("Teapot", 2000);
        products.put("Cell_Phone", 8700);
        products.put("Mixer", 3500);
        products.put("TV", 25400);
        List<String> clients = Arrays.asList("John", "Max");
        try {
            for (String key: products.keySet()) {
                session = factory.getCurrentSession();
                Product product = new Product();
                product.setTitle(key);
                product.setPrice(products.get(key));
                session.beginTransaction();
                session.save(product);
                session.getTransaction().commit();
            }

            for (String s: clients) {
                    session = factory.getCurrentSession();
                    Client client = new Client();
                    client.setName(s);
                    session.beginTransaction();
                    session.save(client);
                    session.getTransaction().commit();
            }
        } finally {
            factory.close();
            session.close();
        }
    }

    public static void showProductsByPerson(String name) {

    }
    public static void findPersonsByProductTitle(String title){

    }
    public static void removePerson(String name) {

    }
    public static void removeProduct(String title) {

    }
    public static void buy(String name, String title) {

    }

}
