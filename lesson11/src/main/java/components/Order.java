package components;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import components.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "price")
    private Integer price;
}
