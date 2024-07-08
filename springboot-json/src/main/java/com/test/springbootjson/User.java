package com.test.springbootjson;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

//批量忽略字段
//@JsonIgnoreProperties({"username","age"})
public class User {

    // 序列化/反序列化时的名称，默认就是属性名，index代表排序，正序
    @JsonProperty(value = "uname", index = 99)
    private String username;
    @JsonProperty(index = 90)
    private Integer age;

    // 序列化/反序列化 时忽略
    @JsonIgnore
    private String address;
    //格式化日期字段，要设置时区
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
