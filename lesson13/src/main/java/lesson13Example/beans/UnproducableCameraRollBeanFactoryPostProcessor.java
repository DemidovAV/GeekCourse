package lesson13Example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UnproducableCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
// �������� ����� ���� BeanDefinition ��� ������� � ������� �� ���
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
// ���������� ��� �����
        for(String name: beanDefinitionNames){
// �������� BeanDefinition �� �����
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            /*�������� ��� ������ ������������ ����, ����� ���������, �������� �� �� ��������� UnproducableCameraRoll */
            String className = beanDefinition.getBeanClassName();
            try {
                // �������� ����� �� �����
                Class<?> beanClass = Class.forName(className);
                /*�������� �������� ������ ��������� � �� ��������, ���� ����� �� �������� ������ ���������, �� ����� ������ null*/
                UnproducableCameraRoll annotation = (UnproducableCameraRoll)beanClass.getAnnotation(UnproducableCameraRoll.class);
                // ���������, �������� �� ����� ��� ���������
                if(annotation != null) {
                // �������� ��������, ��������� � ���������� ��������� (�����������, ������� ���������� ������������)
                    Class usingCameraRollName = annotation.usingCameraRollClass();
                    // ������ ����� �������� ����
                    beanDefinition.setBeanClassName(usingCameraRollName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
