package lesson13HomeWork.components;

import lesson13HomeWork.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderService")
public class OrderService {
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void printOrder() {
        List<Product> orderList = this.cart.getCartList();
        int total = 0;
        System.out.println("Список покупок:");
        for (Product product: orderList) {
            total += product.getProductCost();
            System.out.println(product.getTitle() + ", стоимость " + product.getProductCost() + " руб.");
        }
        System.out.println("Итоговая стоимость продуктов: " + total + " руб.");
    }
}
