package com.test.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(){
        System.out.println("hello2");
        return "hello2";
    }
}
