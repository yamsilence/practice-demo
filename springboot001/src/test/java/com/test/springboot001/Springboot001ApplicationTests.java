package com.test.springboot001;

import com.test.springboot001.mdoel.Apple;
import com.test.springboot001.mdoel.Banana;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot001ApplicationTests {


    @Autowired
    Apple apple;

    @Autowired
    Banana banana;
    @Test
    void contextLoads() {
        System.out.println(apple);
        System.out.println(banana);
    }

}
