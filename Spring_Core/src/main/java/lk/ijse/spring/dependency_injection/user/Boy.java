package lk.ijse.spring.dependency_injection.user;

import jakarta.annotation.PostConstruct;
import lk.ijse.spring.dependency_injection.Wow;
import lk.ijse.spring.dependency_injection.dep.GoodGirl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {

//    // ** Field Injection **=======================================================================================================

    @Autowired //Autowired is used to inject the dependencies to the bean
    @Qualifier("properties")
    @Wow //Custom Annotation
    private GoodGirl goodGirl;

//
//
//

//    // ** Constructor Injection **=========================This is the Recommended Method=====================================
//    @Qualifier("properties")
//    private final GoodGirl goodGirl;
//
//    @Autowired
//    @Wow
//    public Boy(GoodGirl goodGirl) {
//        this.goodGirl = goodGirl;
//    }

//    // ** Setter Injection **=======================================================================================================
//    @Qualifier("properties")
//    private GoodGirl goodGirl;
//
//    @Autowired
//    @Wow
//    public void setGoodGirl(GoodGirl goodGirl) {
//        this.goodGirl = goodGirl;
//    }

    @PostConstruct // This annotation is used to indicate that this method should be executed after the instantiation of the bean,This is not a spring annotation it's a jakarta annotation
    public void init(){
//        System.out.println(goodGirl);
        goodGirl.love();
    }




}

// ** Dependency Injection Types **
// 1. Field Injection
// 2. Constructor Injection
// 3. Setter Injection
// 4. Value Injection