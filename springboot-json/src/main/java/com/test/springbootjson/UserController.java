package com.test.springbootjson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @GetMapping("/getuser")
    public User getUser() {
        User user = new User();
        user.setUsername("javaboy");
        user.setAge(18);
        user.setAddress("www.javaboy.com");
        user.setBirthday(new Date());
        return user;
    }
}
