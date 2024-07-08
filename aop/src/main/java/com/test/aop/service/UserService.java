package com.test.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserById(Integer id){
        System.out.println("getUserById");
      //  System.out.println(1/0);
        return "user";
    }

    public void deleteByUserId(Integer id){
        System.out.println("deleteByUserId");
    }
}
