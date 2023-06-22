package lesson13Example;

import lesson13Example.beans.AppConfig;
import lesson13Example.beans.Camera;
import lesson13Example.beans.NewCamera;
import lesson13Example.beans.OldCamera;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera1 = context.getBean("oldCamera", Camera.class);
        camera1.breaking();
        camera1.doPhotograph();
        Camera camera2 = context.getBean("oldCamera", Camera.class);
        camera2.doPhotograph();
    }
}
