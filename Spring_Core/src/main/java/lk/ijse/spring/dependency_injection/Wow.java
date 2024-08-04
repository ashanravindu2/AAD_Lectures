package lk.ijse.spring.dependency_injection;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME) // This annotation is used to indicate that this annotation should be available at runtime.
public @interface Wow { //@interface Wow is a custom annotation that used to revamp the priority of the GoodGirl beans
}

// ** @Annotation ** //
// Annotation is a special kind of interface that is used to provide metadata to the Java code.

// ** RetentionPolicy ** //
// https://www.geeksforgeeks.org/java-retention-annotations/
// http s://www.baeldung.com/java-default-annoitations