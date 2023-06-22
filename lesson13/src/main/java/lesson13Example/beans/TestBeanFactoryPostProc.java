package lesson13Example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactoryPostProc implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory
                                               beanFactory) throws BeansException {
// ��������� ���� BeanDefinition ���� �����, ����������� �������������
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
// ������� ������� ��� ��������� ������� � ������� �����
        for(String name: beanDefinitionNames) {
// ��������� BeanDefinition �� �����
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
// ����� ���������� � BeanDefinition
            System.out.println(beanDefinition.toString());
        }
    }
}

