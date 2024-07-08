package com.test.springbootyaml;

import com.test.springbootyaml.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootYamlApplicationTests {
    @Autowired
    Book book;

    @Test
    void contextLoads() {
        System.out.println(book);
    }

}
