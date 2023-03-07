package lesson13Example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UnproducableCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
// ѕолучаем имена всех BeanDefinition дл€ доступа к каждому из них
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
// ѕеребираем все имена
        for(String name: beanDefinitionNames){
// ѕолучаем BeanDefinition по имени
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            /*ѕолучаем им€ класса создаваемого бина, чтобы проверить, содержит ли он аннотацию UnproducableCameraRoll */
            String className = beanDefinition.getBeanClassName();
            try {
                // ѕолучаем класс по имени
                Class<?> beanClass = Class.forName(className);
                /*ѕытаемс€ получить объект аннотации и ее значение, если класс не содержит данную аннотацию, то метод вернет null*/
                UnproducableCameraRoll annotation = (UnproducableCameraRoll)beanClass.getAnnotation(UnproducableCameraRoll.class);
                // ѕровер€ем, содержал ли класс эту аннотацию
                if(annotation != null) {
                // ѕолучаем значение, указанное в параметрах аннотации (класспленки, которую необходимо использовать)
                    Class usingCameraRollName = annotation.usingCameraRollClass();
                    // ћен€ем класс будущего бина
                    beanDefinition.setBeanClassName(usingCameraRollName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
