import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SessionManager {

    private Map<String, Integer> products = new HashMap<>();
    private List<String> clients = Arrays.asList("John", "Max");

    private SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .buildSessionFactory();
    private Session session;

    public void startSession() {
        products.put("MP3_Player", 5600);
        products.put("Teapot", 2000);
        products.put("Cell_Phone", 8700);
        products.put("Mixer", 3500);
        products.put("TV", 25400);
        try {
            String sql = Files.lines(Paths.get("D:\\For java\\GeekCourses\\lesson11\\src\\main\\java\\sql-request.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startDBManagement() {
            Scanner sc = new Scanner(System.in);
            session = factory.getCurrentSession();
            System.out.println("Waiting for command \nFor list of commands type: /commandList");
            while (sc.hasNext()) {
                try {
                    String command = sc.nextLine();
                    if (command.equals("/exit")) break;
                    String[] commandArr = command.split(" ");
                    if (commandArr.length == 0) System.out.println("Unknown command. Waiting for proper command.");
                    switch (commandArr[0]) {
                        case "/commandList" -> {
                            CommandList commandList = new CommandList();
                            for (String s : commandList.getCommandsList()) {
                                System.out.println(s);
                            }
                            System.out.println("Input command");
                        }
                        case "/buy" -> {
                            session = factory.getCurrentSession();
                            session.beginTransaction();
                            Client client = (Client) session.createQuery("FROM Client WHERE name = :name")
                                    .setParameter("name", commandArr[1]).getSingleResult();
                            Product product = (Product) session.createQuery("FROM Product WHERE title = :title")
                                    .setParameter("title", commandArr[2]).getSingleResult();
                            Order order = new Order();
                            order.setClient(client);
                            order.setProduct(product);
                            order.setPrice(product.getPrice());
                            session.save(order);
                            session.getTransaction().commit();
                            System.out.println("New order id = " + order.getId() + " created. Client: " + client.getName() + ", Product: " + product.getTitle() + ", Price: "
                                    + order.getPrice());
                        }
                        case "/showProductsByClient" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();
                                Client clientShow = (Client) session.createQuery("FROM Client WHERE name = :name").
                                        setParameter("name", commandArr[1]).getSingleResult();
                                List<Order> clientOrders = clientShow.getOrders();
                                System.out.print(clientShow.getName() + "'s orders: ");
                                clientOrders.forEach(o -> System.out.print(o.getProduct().getTitle() + ", Price: " + o.getProduct().getPrice() + " | "));
                                System.out.println("");
                            } catch (NullPointerException e) {
                                System.out.println("No such client in database");
                            } finally {
                                session.getTransaction().commit();
                            }
                            System.out.println("Waiting for command:");
                        }
                        case "/findClientsByProductTitle" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();

                                Product productShow = (Product) session.createQuery("FROM Product WHERE title = :title")
                                        .setParameter("title", commandArr[1]).getSingleResult();
                                List<Order> productOrders = productShow.getOrders();
                                System.out.print(productShow.getTitle() + " was ordered by: ");
                                productOrders.forEach(o -> System.out.print(o.getClient().getName() + " | "));
                                System.out.println("");
                            } catch (NullPointerException e) {
                                System.out.println("No such product in database");
                            } finally {
                                session.getTransaction().commit();
                            }
                            System.out.println("Waiting for command:");
                        }
                        case "/removeClient" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();
                                Client deleteClient = (Client) session.createQuery("FROM Client WHERE name = :name").
                                        setParameter("name", commandArr[1]).getSingleResult();
                                session.delete(deleteClient);
                                System.out.println("Client " + deleteClient.getName() + " has been deleted from database.");
                            } catch (NullPointerException e) {
                                System.out.println("No such client int database.");
                            } finally {
                                session.getTransaction().commit();
                            }
                            System.out.println("Waiting for command:");
                        }
                        case "/removeProduct" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();
                                Product deleteProduct = (Product) session.createQuery("FROM Product WHERE title = :title").
                                        setParameter("title", commandArr[1]).getSingleResult();
                                session.delete(deleteProduct);
                                System.out.println("Product " + deleteProduct.getTitle() + " has been deleted from database.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("No such product in database");
                            } finally {
                                session.getTransaction().commit();
                            }
                            System.out.println("Waiting for command:");
                        }
                        case "/addClient" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();
                                Client newClient = new Client();
                                newClient.setName(commandArr[1]);
                                session.save(newClient);
                                System.out.println("Client " + newClient.getName() + " was added to database.");
                                System.out.println("Waiting for command:");
                            } finally {
                                session.getTransaction().commit();
                            }
                        }
                        case "/addProduct" -> {
                            try {
                                session = factory.getCurrentSession();
                                session.beginTransaction();
                                Product newProduct = new Product();
                                newProduct.setTitle(commandArr[1]);
                                newProduct.setPrice(Integer.parseInt(commandArr[2]));
                                session.save(newProduct);
                                System.out.println("Product " + newProduct.getTitle() + " was added to database.");
                                System.out.println("Waiting for command:");
                            } finally {
                                session.getTransaction().commit();
                            }
                        }
                        default -> System.out.println("Unknown command. Waiting for proper command.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Wrong command, waiting for correct input.");
                }
            }
        }

    public void stopSession() {
        factory.close();
        if (session != null) {
            session.close();
        }
    }
}
