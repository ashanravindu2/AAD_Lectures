package lk.ijse.spring.dependency_injection.user;

import jakarta.annotation.PostConstruct;
import lk.ijse.spring.dependency_injection.Wow;
import lk.ijse.spring.dependency_injection.dep.GoodGirl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Boy {

    @Autowired
    @Qualifier("properties")
    @Wow //Custom Annotation
    private GoodGirl goodGirl;

    @PostConstruct // This annotation is used to indicate that this method should be executed after the instantiation of the bean
    public void init(){
//        System.out.println(goodGirl);
        goodGirl.love();
    }
}
