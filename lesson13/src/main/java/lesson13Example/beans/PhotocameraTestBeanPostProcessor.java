package lesson13Example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Camera) {
            System.out.println("����� ������� ����!");
// ������ ������� ����
            ((Camera) bean).doPhotograph();
            System.out.println("�������! ��������!");
        }
// � ������ ������ ������ ���������� ���
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
// ������� ��� ������ ����������
        return bean;
    }
}
