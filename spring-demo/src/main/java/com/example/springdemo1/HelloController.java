package com.example.springdemo1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/greetings")
    public String index() {
        System.out.println("inside test program");
    	return "Greetings from Spring Boot and docker jimmy!";
    }

}
