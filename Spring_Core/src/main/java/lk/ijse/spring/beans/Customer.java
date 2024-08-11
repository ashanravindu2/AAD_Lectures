package lk.ijse.spring.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customer") // This annotation is used to indicate that this is a component class
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // This annotation is used to indicate that this is a singleton scope class (singleton scope means that only one instance of the class is created)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // This annotation is used to indicate that this is a prototype scope class (prototype scope means that multiple instances of the class are created)
public class Customer {
    public Customer() {
        System.out.println("Customer Instantiated");
    }
}
