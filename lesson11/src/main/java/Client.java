import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {this.name = name;}

    public int getId() {return id;}

    public String getName() {return name;}

    public Client() {}

    public Client(String name) {this.name = name;}
}