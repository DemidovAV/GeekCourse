package com.example.lesson15.services;

import com.example.lesson15.entities.Product;
import com.example.lesson15.repositories.ProductRepository;
import com.example.lesson15.repositories.ProductRepository1;
import com.example.lesson15.repositories.specifications.ProductSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> getProductsWithPaginationAndFiltering(Specification<Product> specification, Pageable pageable) {
        return productRepository.findAll(specification, pageable);
    }

    public List<Product> getAllItems() {
        return productRepository.findAll(PageRequest.of(0, 10)).getContent();
    }

    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productRepository.findOne(ProductSpecs.findById(id)).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


//    public void saveEditedProduct(Product product) {
//        productRepository1.saveEditedProduct(product);
//    }

}
