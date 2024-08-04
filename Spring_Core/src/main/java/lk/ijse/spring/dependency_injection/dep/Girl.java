package lk.ijse.spring.dependency_injection.dep;

import org.springframework.stereotype.Component;

@Component
public class Girl implements GoodGirl {
    @Override
    public void love() {
        System.out.println("Love you from Girl");
    }
}
