package lk.ijse.spring.config;

import lk.ijse.spring.aop.Transaction;
import lk.ijse.spring.beans.Customer;
import lk.ijse.spring.beans.Order;
import lk.ijse.spring.beans.spring_bean_lifecycle.TestBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration // This annotation is used to indicate that this is a configuration class (configuration class means that this class is used to configure the beans) = source for bean definitions
//@ComponentScan(basePackages = "lk.ijse.spring") // This annotation is used to indicate that this class is a component scanning class(component scanning means that
// this class is used to scan the components)
// basePackages attribute is used to specify the base package to scan the components
//@ComponentScan(basePackageClasses = {Customer.class}) // BaseClass attribute is used to specify the base class to scan the components

@ComponentScan(basePackageClasses = { Transaction.class, TestBean.class })
@EnableAspectJAutoProxy
public class Config {
    @Bean // This annotation used to register classes as component that we don't have the source code
    public Order order(){
        return new Order();
    }
}


// ** Bean VS Component

//@Component
//Used to indicate that a class is a Spring-managed component.
//Automatically detected during classpath scanning.
//Typically used for classes that are not explicitly configured in a configuration class.


//@Bean
//Used to explicitly declare a single bean in a Spring configuration class.
//Provides more control over the instantiation and configuration of the bean.
//Typically used for third-party classes or when you need to configure the bean in a specific way.