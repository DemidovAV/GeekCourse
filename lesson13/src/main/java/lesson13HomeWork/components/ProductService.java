package lesson13HomeWork.components;

import lesson13HomeWork.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("productService")
public class ProductService {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void printAll() {
        for (Product product: this.productList) {
            System.out.println("id товара: " + product.getId()  + ", название: " + product.getTitle() +
                    ", цена: " + product.getProductCost() + " руб.");
        }
    }

    public Product findByTitle(String title) throws NullPointerException {
        for (Product product: this.productList) {
            if (product.getTitle().equals(title)) {
                return product;
            }
        }
        return null;
    }

    @PostConstruct
    public void setProductList(){
        this.productList = new ArrayList<>();
        this.productList.add(new Product(1, "Картошка", 30));
        this.productList.add(new Product(2, "Капуста", 10));
        this.productList.add(new Product(3, "Грибы", 120));
        this.productList.add(new Product(4, "Молоко", 70));
        this.productList.add(new Product(5, "Йогурт", 50));
        this.productList.add(new Product(6, "Зубная паста", 180));
        this.productList.add(new Product(7, "Сыр", 230));
        this.productList.add(new Product(8, "Колбаса", 240));
        this.productList.add(new Product(9, "Мюсли", 110));
        this.productList.add(new Product(10, "Кола", 80));
    }
}
