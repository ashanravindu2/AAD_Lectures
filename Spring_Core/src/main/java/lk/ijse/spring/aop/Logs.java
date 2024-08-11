package lk.ijse.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logs {
    @Before("execution(public void startTransaction())")
    public void logsForTransaction(){
        System.out.println("Log for Transaction Started");
    }
    @Before("execution(public void endTransaction())")
    public void endTransaction(){
        System.out.println("Log for Transaction Ended");
    }
}
