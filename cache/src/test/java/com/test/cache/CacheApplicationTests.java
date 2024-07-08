package com.test.cache;

import com.test.cache.model.User;
import com.test.cache.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 3; i++) {
            User user = userService.getUserById(99L);
            System.out.println(user);
        }
    }

    @Test
    void test() {
        User u1 = userService.getUserById2(99L, "zs");
        User u2 = userService.getUserById2(99L, "ls");

    }

    @Test
    void test2() {
        User u1 = userService.getUserById(100L);
        System.out.println("u1：" + u1);
        u1.setName("jack");
        userService.updateUser(u1);
        User u2 = userService.getUserById(100L);
        System.out.println("u2:" + u2);
    }

    @Test
    void test3() {
        User u1 = userService.getUserById(100L);
        userService.deleteUser(100L);
        User u2 = userService.getUserById(100L);
        System.out.println("u2:" + u2);
    }

    @Test
    void test4() {
        User u1 = userService.getUserById(100L);
        System.out.println(u1);
    }

    @Test
    void test5() {
        userService.deleteUser(100L);
    }


}
