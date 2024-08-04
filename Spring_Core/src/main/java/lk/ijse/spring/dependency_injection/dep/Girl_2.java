package lk.ijse.spring.dependency_injection.dep;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // This annotation used to indicate that this is the primary bean when there are multiple beans of the same type
public class Girl_2 implements GoodGirl  {

    @Override
    public void love() {
        System.out.println("Love you from Girl_2");
    }
}
