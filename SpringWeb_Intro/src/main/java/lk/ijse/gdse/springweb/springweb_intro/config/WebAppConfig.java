package lk.ijse.gdse.springweb.springweb_intro.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // using this annotation we can make this class as a configuration class
@ComponentScan(basePackages = "lk.ijse.gdse.springweb.springweb_intro") // using this annotation we can define the base package for this configuration class
public class WebAppConfig {
}
