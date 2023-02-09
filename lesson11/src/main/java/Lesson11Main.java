import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Lesson11Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Product product = new Product();
            product.setTitle("MP3_Player");
            product.setPrice(5600);
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
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
