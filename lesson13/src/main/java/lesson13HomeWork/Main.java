package lesson13HomeWork;

import lesson13HomeWork.components.Cart;
import lesson13HomeWork.components.OrderService;
import lesson13HomeWork.components.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopAppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        productService.printAll();
        System.out.println("\n");

        try {
            System.out.println(productService.findByTitle("������ �����").toString());
        } catch (NullPointerException e) {
            System.out.println("������� �� ������");
        }
        System.out.println("\n");

        cart.add(productService.findByTitle("��������"));
        cart.add(productService.findByTitle("�������"));
        cart.add(productService.findByTitle("������"));
        cart.add(productService.findByTitle("������"));
        cart.add(productService.findByTitle("�������"));
        System.out.println("\n");

        orderService.printOrder();
    }
}
