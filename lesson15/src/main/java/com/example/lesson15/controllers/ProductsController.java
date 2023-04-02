package com.example.lesson15.controllers;


import com.example.lesson15.entities.Product;
import com.example.lesson15.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                                  @RequestParam(value = "filter", required = false) String filter,
                                  @RequestParam(value = "min", required = false) Integer min,
                                  @RequestParam(value = "max", required = false) Integer max) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProductsFiltered(filter, min, max));
        model.addAttribute("product", product);
        model.addAttribute("filter", filter);
        model.addAttribute("filter", min);
        model.addAttribute("filter", max);
        return "products";
    }
    @PostMapping
    public String showProductListReset(Model model) {
        Product product = new Product();
        String filter = null;
        Integer min = null;
        Integer max = null;
        model.addAttribute("products", productService.getAllProductsFiltered(filter, min, max));
        model.addAttribute("product", product);
        model.addAttribute("filter", filter);
        model.addAttribute("filter", min);
        model.addAttribute("filter", max);
        return "products";
    }
    @GetMapping("/edit/{id}")
    public String showEditProduct(Model model, @PathVariable(value="id") Long id){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products-edit";
    }

    @PostMapping("/edit/confirm")
    public String editConfirm(@ModelAttribute(value="product") Product product) {
        productService.saveEditedProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "products-add";
    }

    @PostMapping("/add/confirm")
    public String addConfirm(@ModelAttribute(value="product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/show_product/{id}")
    public String showOneProduct(Model model, @PathVariable(value="id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value="id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }


}
