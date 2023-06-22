package lesson13Example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Camera) {
            System.out.println("Делаю пробное фото!");
// Делаем пробное фото
            ((Camera) bean).doPhotograph();
            System.out.println("Отлично! Работает!");
        }
// В данном методе просто возвращаем бин
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
// Находим бин класса фотокамеры
        return bean;
    }
}
