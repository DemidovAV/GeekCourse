import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private int price;

    @ManyToMany
    @JoinTable (name = "clients_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setId(int id) {this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setPrice(int price) {this.price = price;}

    public int getId() {return id;}

    public String getName() {return title;}

    public int getPrice() {return price;}

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
    public Product() {}

    @Override
    public String toString() {
        return title + " -- price is: " + price + " rub.";
    }
}
