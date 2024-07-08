package com.test.controlleradvice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// @ControllerAdvice  //@Controller
@RestControllerAdvice // @RestController
public class MyGlobalException {

    @ExceptionHandler(Exception.class)
    public String customException(Exception e) {
        return e.getMessage();
    }

    @ModelAttribute("info")
    public Map<String, String> myData() {
        Map<String, String> info = new HashMap<>();
        info.put("username", "zs");
        info.put("age", "18");
        return info;
    }

    @InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}
