package com.test.controlleradvice;

import com.test.controlleradvice.model.Author;
import com.test.controlleradvice.model.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public void hello() {
        System.out.println(1 / 0);
    }

    @GetMapping("/mydata")
    public void myData(Model model) {
        Map<String, Object> map = model.asMap();
        // Map<String, Object> info = (Map<String, Object>) map.get("map");
        Map<String, Object> info = (Map<String, Object>) map.get("info");
        Set<String> keySet = info.keySet();
        for (String key : keySet) {
            System.out.println(key + "----" + info.get(key));
        }
    }

    @PostMapping("/add")
    public void add(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author) {
        System.out.println(book);
        System.out.println(author);
    }
}
