package lk.ijse.spring.beans.spring_bean_lifecycle;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// Test class for Spring Bean Lifecycle

@Component("TestBean")
public class TestBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean factory is: "+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name: "+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context: "+applicationContext);
    }

    @PreDestroy //This annotation is used to indicate that this is a custom destroy method and it will be called before the bean is destroyed
    public void customDestroyTest(){
        System.out.println("Custom destroy method called");
    }
}


