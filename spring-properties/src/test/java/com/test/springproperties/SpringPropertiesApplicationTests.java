package com.test.springproperties;

import com.test.springproperties.model.Book;
import com.test.springproperties.model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringPropertiesApplicationTests {
    @Autowired
    Book book;
    @Autowired
    Dog dog;

    @Test
    void contextLoads() {
        System.out.println(book);
        System.out.println(dog);
    }

}
