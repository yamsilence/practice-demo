package com.test.cors02;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(value = "http://localhost:8081",maxAge = 1800)
@RestController
public class HelloController {

  //  @CrossOrigin(value = "http://localhost:8081")
    @GetMapping("/hello")
    public String hello(){
        return "hello cors";
    }

    @PutMapping("/hello2")
    public String hello2(){
        return "hello cors put";
    }
}
