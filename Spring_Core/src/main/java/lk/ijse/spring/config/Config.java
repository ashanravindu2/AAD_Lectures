package lk.ijse.spring.config;

import lk.ijse.spring.beans.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // This annotation is used to indicate that this is a configuration class
@ComponentScan(basePackages = "lk.ijse.spring") // This annotation is used to indicate that this class is a component scanning class(component scanning means that
// this class is used to scan the components)
// basePackages attribute is used to specify the base package to scan the components
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