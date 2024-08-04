package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // This annotation is used to indicate that this is a configuration class
@ComponentScan(basePackages = "lk.ijse.spring") // This annotation is used to indicate that this class is a component scanning class(component scanning means that
// this class is used to scan the components)
// basePackages attribute is used to specify the base package to scan the components
public class Config {

}
