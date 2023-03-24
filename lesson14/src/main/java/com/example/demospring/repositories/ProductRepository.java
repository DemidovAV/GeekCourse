package com.example.demospring.repositories;

import com.example.demospring.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Bread", 30));
        products.add(new Product(2L, "Carrot", 5));
        products.add(new Product(3L, "Bacon", 200));
        products.add(new Product(4L, "Chocolate", 90));
    }

    public List<Product> finAll() {
        return products;
    }

    public Product findByTitle(String title) {
        return products.stream().filter(product -> product.getTitle().equals(title)).findFirst().get();
    }

    public Product findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    public void saveProduct(Product product) {
        if (products.size() > 0) {
            Long id = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
            product.setId(id);
            products.add(product);
        } else {
            product.setId(1L);
            products.add(product);
        }
    }

    public void deleteProductById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public void saveEditedProduct(Product product) {
        for(Product p: products) {
            if (product.getId().equals(p.getId())) {
                p.setTitle(product.getTitle());
                p.setPrice(product.getPrice());
            }
        }
    }

}
