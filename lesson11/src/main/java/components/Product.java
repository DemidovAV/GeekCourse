package components;

import javax.persistence.*;

import components.Order;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "title")
    private String title;

    @Column (name = "price")
    private int price;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Order> orders;


    @Override
    public String toString() {
        return title;
    }
}
