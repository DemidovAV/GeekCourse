package com.example.lesson15.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column
    private Long cost;

    public Item(Long id, String title, Long cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Item [%d, %s, price - %d]", id, title, cost);
    }
}
