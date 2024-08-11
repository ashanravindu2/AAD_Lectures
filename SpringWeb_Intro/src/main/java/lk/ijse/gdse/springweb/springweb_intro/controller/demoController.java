package lk.ijse.gdse.springweb.springweb_intro.controller;

import jakarta.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/demo")  // using this annotation we can define the base URL for this controller
@RestController  // using this annotation we can make this class as a controller
public class DemoController {
    @GetMapping(value = "/health")  // using this annotation we can define the URL for this method
    public String health(){
        return "I'm OK";
    }
}
