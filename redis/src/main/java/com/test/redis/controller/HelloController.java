package com.test.redis.controller;


import com.test.redis.anno.AutoIdempotent;
import com.test.redis.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/test")
    public void test(HttpServletRequest request) {

    }


    @GetMapping("/gettoken")
    public String getToken() {
        return tokenService.createToken();
    }


    @PostMapping("/hello")
    @AutoIdempotent
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello2")
    public String hello2() {
        return "hello2";
    }

}
