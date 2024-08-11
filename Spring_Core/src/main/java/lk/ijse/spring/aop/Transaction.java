package lk.ijse.spring.aop;

//Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns. Here are the key concepts:
//
//        1. **Aspect**: A module that encapsulates a concern that cuts across multiple classes, such as logging or transaction management.
//        2. **Join Point**: A point in the execution of the program, such as method execution or object instantiation, where an aspect can be applied.
//        3. **Advice**: Action taken by an aspect at a particular join point. Types of advice include "before", "after", and "around".
//        4. **Pointcut**: A set of join points where an advice should be applied. It defines when and where the advice should be executed.
//        5. **Weaving**: The process of applying aspects to a target object to create a new proxy object. This can be done at compile-time, load-time, or runtime.

//AOP is commonly used in frameworks like Spring to handle concerns such as logging, security, and transaction management without cluttering the business logic.
//Java not directly supporting for aop
import org.springframework.stereotype.Component;

@Component ("transaction")
public class Transaction {
    public void startTransaction(){
        System.out.println("Starting transaction");
    }
    public void endTransaction(){
        System.out.println("End transaction");
    }
}
