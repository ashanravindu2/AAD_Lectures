package lk.ijse.gdse.notetaker.config;


import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.notetaker")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.notetaker.dao")
@EnableTransactionManagement
@MultipartConfig(
        fileSizeThreshold = 0,  //
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 0    //
)
public class WebAppConfig {
}
