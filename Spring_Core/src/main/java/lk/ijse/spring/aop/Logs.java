package lk.ijse.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect //this annotation is used to indicate that this is an aspect class,using aspect classes we can define the advices for the beans
@EnableAspectJAutoProxy // this annotation is used to enable the aspectJ auto proxy,using aspectJ auto proxy we can create proxies for the beans,
// using those proxies we can apply the advices for the beans
public class Logs {
    @Before("execution(public void startTransaction())") //this annotation is used to define the pointcut of the advice,pointcut means the method that we need to apply the advice
    public void logsForTransaction(){ //this is the advice for the logForTransaction method,this trigger before triggering startTransaction() method
        System.out.println("Log for Transaction Started");
    }
    @Before("execution(public void endTransaction())") //this annotation is used to define the pointcut of the advice
    public void endTransaction(){
        System.out.println("Log for Transaction Ended");
    }
}
