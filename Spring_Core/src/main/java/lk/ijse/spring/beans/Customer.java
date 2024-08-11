package lk.ijse.spring.beans;

import org.springframework.stereotype.Component;

@Component("customer") // This annotation is used to indicate that this is a component class
public class Customer {
    public Customer() {
        System.out.println("Customer Instantiated");
    }
}
