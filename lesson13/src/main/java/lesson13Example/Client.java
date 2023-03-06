package lesson13Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera1 = context.getBean("oldCamera", Camera.class);
        camera1.doPhotograph();
        Camera camera2 = context.getBean("newCamera", Camera.class);
        camera2.doPhotograph();
    }
}
