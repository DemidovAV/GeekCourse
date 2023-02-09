import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.List;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setPrice(int price) {this.price = price;}

    public int getId() {return id;}

    public String getName() {return name;}

    public int getPrice() {return price;}

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Good() {}
}
