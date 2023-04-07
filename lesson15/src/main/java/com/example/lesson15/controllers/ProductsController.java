package com.example.lesson15.controllers;


import com.example.lesson15.entities.Item;
import com.example.lesson15.entities.Product;
import com.example.lesson15.repositories.specifications.ItemSpecs;
import com.example.lesson15.repositories.specifications.ProductSpecs;
import com.example.lesson15.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductList(Model model,
                                  @RequestParam (value = "page", required = false) Integer page,
                                  @RequestParam(value = "filter", required = false) String filter,
                                  @RequestParam(value = "min", required = false) Integer min,
                                  @RequestParam(value = "max", required = false) Integer max) {
        if (page == null) {
            page = 1;
        }
        Product product = new Product();
        Specification<Product> spec = Specification.where(null);
        if(min != null) {
            spec = spec.and(ProductSpecs.priceGreaterThanOrEquals(min));
        }
        if(filter != null) {
            spec = spec.and((ProductSpecs.titleContains(filter)));
        }
        if(max != null) {
            spec = spec.and(ProductSpecs.priceLessThanOrEquals(max));
        }

        List<Product> listOfProducts = productService.getProductsWithPaginationAndFiltering(spec, PageRequest.of(page - 1, 3)).getContent();

        model.addAttribute("filter", filter);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("products", listOfProducts);
        model.addAttribute("product", product);
        return "products";
    }
    @PostMapping
    public String showProductListReset(Model model) {
        Product product = new Product();
        String filter = null;
        Integer min = null;
        Integer max = null;
        Specification<Product> spec = Specification.where(null);
        List<Product> listOfProducts = productService.getProductsWithPaginationAndFiltering(spec, PageRequest.of(0, 10)).getContent();
        model.addAttribute("products", listOfProducts);
        model.addAttribute("product", product);
        model.addAttribute("filter", filter);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "products";
    }
    @GetMapping("/edit/{id}")
    public String showEditProduct(Model model, @PathVariable(value="id") Long id){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products-edit";
    }
//
    @PostMapping("/edit/confirm")
    public String editConfirm(@ModelAttribute(value="product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
//
//
    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
//        productService.setLastIdToProduct(product);
        model.addAttribute("product", product);
        return "products-add";
    }
//
    @PostMapping("/add/confirm")
    public String addConfirm(@ModelAttribute(value="product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
//
    @GetMapping("/show_product/{id}")
    public String showOneProduct(Model model, @PathVariable(value="id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_page";
    }
//
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value="id") Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }


}
