package com.test.validation.controller;


import com.test.validation.groups.VaildationGroup1;
import com.test.validation.groups.VaildationGroup2;
import com.test.validation.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @PostMapping("/add")
    public void add(@Validated(VaildationGroup1.class) User user, BindingResult result) {
        if (result != null) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }

    }

    @PostMapping("/add2")
    public void add2(@Validated(VaildationGroup2.class) User user, BindingResult result) {
        if (result != null) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }

    }
}
