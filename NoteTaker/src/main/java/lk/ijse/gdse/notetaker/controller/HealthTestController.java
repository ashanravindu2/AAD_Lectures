package lk.ijse.gdse.notetaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthtest")
public class HealthTestController {

    @GetMapping
    public String healthTest(){
        return "Note collector app run successful!";
    }
}
