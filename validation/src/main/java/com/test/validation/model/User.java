package com.test.validation.model;

import com.test.validation.groups.VaildationGroup1;
import com.test.validation.groups.VaildationGroup2;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotNull(message = "用户唯一标识不能为空！", groups = {VaildationGroup1.class, VaildationGroup2.class})
    private Long id;

    @NotNull(message = "用户名不能为空！", groups = {VaildationGroup1.class})
    @Size(min = 2, max = 6, message = "用户名长度介于2-6之间！")
    private String username;

    @Max(value = 150, message = "年龄不能大于150！", groups = {VaildationGroup2.class})
    private Integer age;

    @Email
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
