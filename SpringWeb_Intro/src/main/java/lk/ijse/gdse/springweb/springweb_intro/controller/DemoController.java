package lk.ijse.gdse.springweb.springweb_intro.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

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
    @GetMapping(params = "testall") //http://localhost:8080/SpringWebIntro/demo?test=all
    public String getWithParams(){
        return "All are tested";
    }
    @GetMapping
    public String otherTest(){
        return "Other test";
    }

    @GetMapping(params = "test=all") //http://localhost:8080/SpringWebIntro/demo?test=all
    public String params(){
        return "All are tested";
    }
    @PostMapping(params = {"value","quantity"}) //http://localhost:8080/SpringWebIntro/demo?value=100&quantity=10
    public String paramData(@RequestParam  String param1, @RequestParam String param2){
       return "Param1: "+param1+" and Param2: "+param2;
    }

    @GetMapping(value = "/health/{id:C\\d{3}}",headers = "x-number") //http://localhost:8080/SpringWebIntro/demo/patternRegex/C001
    public String pathVariableWithRegixWithHeader(@PathVariable("id") String id, @RequestHeader("x-number") String number){
       return "Pattern Regex: "+id+" and Header: "+number;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //http://localhost:8080/SpringWebIntro/demo
    public String saveJSON(){
        return "Json Save";
    }

    @PostMapping("/dynamic/{value:\\d{2}}") //http://localhost:8080/SpringWebIntro/demo/patternRegex/C001
    public ResponseEntity<String> returnDynamicData(@PathVariable("value") int incomingValue){

        if(incomingValue%2==0){
            return ResponseEntity.ok("Even Number");
        }else{
            return ResponseEntity.badRequest().body("Odd Number");
        }
    }
}
