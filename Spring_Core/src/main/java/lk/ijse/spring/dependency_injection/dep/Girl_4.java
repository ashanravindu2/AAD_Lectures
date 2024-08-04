package lk.ijse.spring.dependency_injection.dep;

import lk.ijse.spring.dependency_injection.Wow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("properties")
@Wow //Custom Annotation
public class Girl_4 implements GoodGirl{
    @Override
    public void love() {
        System.out.println("Love you from Girl_4");
    }
}
