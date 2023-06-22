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
            System.out.println("id ������: " + product.getId()  + ", ��������: " + product.getTitle() +
                    ", ����: " + product.getProductCost() + " ���.");
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
        this.productList.add(new Product(1, "��������", 30));
        this.productList.add(new Product(2, "�������", 10));
        this.productList.add(new Product(3, "�����", 120));
        this.productList.add(new Product(4, "������", 70));
        this.productList.add(new Product(5, "������", 50));
        this.productList.add(new Product(6, "������ �����", 180));
        this.productList.add(new Product(7, "���", 230));
        this.productList.add(new Product(8, "�������", 240));
        this.productList.add(new Product(9, "�����", 110));
        this.productList.add(new Product(10, "����", 80));
    }
}
