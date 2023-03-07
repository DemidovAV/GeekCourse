package lesson13HomeWork.components;

import lesson13HomeWork.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("cart")
public class Cart {
    private List<Product> cartList = new ArrayList<>();

    public List<Product> getCartList() {
        return cartList;
    }

    public void add(Product product) {
        cartList.add(product);
        System.out.println("В корзину добавлен товар: " + product.getTitle());
    }
}
