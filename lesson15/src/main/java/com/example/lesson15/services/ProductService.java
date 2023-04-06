package com.example.lesson15.services;

import com.example.lesson15.entities.Product;
import com.example.lesson15.repositories.ProductRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository1 productRepository1;

    @Autowired
    public void setProductRepository(ProductRepository1 productRepository1) {
        this.productRepository1 = productRepository1;
    }

    public List<Product> getAllProductsFiltered(String filter, Integer min, Integer max) {
        List<Product> preFilteredList = productRepository1.finAll();
        List<Product> afterFilteredList;
        if (filter != null) {
            afterFilteredList = preFilteredList.stream().filter(p-> p.getTitle().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
        } else {
            afterFilteredList = preFilteredList;
        }
        if (min != null && max != null) {
            return afterFilteredList.stream().filter(product -> product.getPrice() >= min && product.getPrice() <= max).collect(Collectors.toList());
        } else if (min == null && max != null) {
            return afterFilteredList.stream().filter(product -> product.getPrice() <= max).collect(Collectors.toList());
        } else if (min != null && max == null) {
            return afterFilteredList.stream().filter(product -> product.getPrice() >= min).collect(Collectors.toList());
        } else {
            return afterFilteredList;
        }
    }

    public Product getProductById(Long id) {
        return productRepository1.findById(id);
    }

    public Product getProductByTitle(String title) {
        return productRepository1.findByTitle(title);
    }

    public void saveProduct(Product product) {
        productRepository1.saveProduct(product);
    }

    public void deleteProductById(Long id) {
        productRepository1.deleteProductById(id);
    }

    public void saveEditedProduct(Product product) {
        productRepository1.saveEditedProduct(product);
    }

}
