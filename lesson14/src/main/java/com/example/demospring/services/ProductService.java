package com.example.demospring.services;

import com.example.demospring.entities.Product;
import com.example.demospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProductsFiltered(String filter) {
        List<Product> productList = productRepository.finAll();
        if (filter != null) {
            return productList.stream().filter(p-> p.getTitle().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
        } else {
            return productList;
        }
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product getProductByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    public void saveEditedProduct(Product product) {
        productRepository.saveEditedProduct(product);
    }

}
