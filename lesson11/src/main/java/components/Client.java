package components;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy= "client", fetch = FetchType.EAGER)
    private List<Order> orders;

    @Override
    public String toString() {
        return name;
    }
}
