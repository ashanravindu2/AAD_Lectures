package lk.ijse.gdse.springweb.springweb_intro.controller;

import jakarta.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
//The @RequestMapping annotation in Spring Web is used to map web requests to specific handler classes and/or handler methods.
// It can be applied at the class level and/or at the method level in a controller.
@RestController  // The @RestController annotation in Spring Web is a specialized version of the @Controller annotation.
// It is used to create RESTful web services. The @RestController annotation is a combination of @Controller and @ResponseBody,
// which means that it not only marks the class as a controller but also ensures that the return values of the methods are automatically
// serialized into JSON or XML and sent back to the client.
public class DemoController {
 // using this annotation we can define the URL for this method
 // using this mapping we can define the URL for this method

    @GetMapping("/health")
    public String health(){    //http://localhost:8080/SpringWebIntro/demo/health
        return "DemoController is running perfectly";
    }
    @GetMapping("/health/**")
    public String healthWithasterix(@PathVariable("name") String name){  //http://localhost:8080/SpringWebIntro/demo/health/Demo
        return "DemoController is running perfectly with: "+ name;
    }
    @GetMapping("/health/{name}")
    public String healthCheck(@PathVariable("name") String name){  //http://localhost:8080/SpringWebIntro/demo/health/Demo
        return "DemoController is running perfectly with: "+ name;
    }
    @GetMapping(value = "patternRegex/{id:C\\d{3}}") //http://localhost:8080/SpringWebIntro/demo/patternRegex/C001
    public String testRegex(@PathVariable("id") String id){
        return "Pattern Regex: "+id;
    }
    @GetMapping(params = "test=all") //http://localhost:8080/SpringWebIntro/demo?test=all
    public String getWithParams(){
        return "All are tested";
    }
    @GetMapping
    public String otherTest(){
        return "Other test";
    }
}
