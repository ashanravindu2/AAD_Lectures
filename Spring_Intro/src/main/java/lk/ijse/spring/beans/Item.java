package lk.ijse.spring.beans;

import org.springframework.stereotype.Component;

@Component // This annotation is used to indicate that this is a component class
public class Item {
    public Item() {
        System.out.println("Item Instantiated");
    }
}