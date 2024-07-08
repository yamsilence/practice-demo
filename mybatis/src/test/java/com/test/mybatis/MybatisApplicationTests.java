package com.test.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.mybatis.mapper.UserMapper;
import com.test.mybatis.mapper.UserMapper2;
import com.test.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapper2 userMapper2;

    @Test
    void contextLoads() {
        User user = userMapper.getUserById(1L);
        System.out.println(user);
    }

    @Test
    void test2() {
        List<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    void test3() {
        User user = new User();
        user.setUsername("ww");
        user.setAddress("yantai");
        user.setPhone("18888888888");
        userMapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    void test4() {
        userMapper.deleteById(5L);
        userMapper.updateUserById("haha", 4L);
    }

    @Test
    void test5() {
        User user = userMapper2.getUserById(1L);
        System.out.println(user);
        List<User> allUser = userMapper2.getAllUser();
        System.out.println(allUser);
        User user1 = new User();
        user1.setUsername("jack");
        userMapper2.insertUser(user1);
        System.out.println(user1);
        //  userMapper2.deleteById(7L);
        userMapper2.updateUserById("xiaoming", 4L);
    }

    @Test
    void test6() {
        List<User> userPage = userMapper2.getUserPage(3, 3);
        //  System.out.println(userPage);
        User user = new User();
        user.setUsername("jack");
        List<User> userByCondition = userMapper2.getUserByCondition(user);
       // System.out.println(userByCondition);
        User user1 = new User();
        user1.setId(12L);
        user1.setUsername("tom");
        user1.setPhone("13577777777");
        userMapper2.updateUser(user1);
    }

    @Test
    void  test7(){
        List<User> userByIds = userMapper2.getUserByIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(userByIds);
    }

    @Test
    void  test8(){
        User user1 = new User();
        user1.setUsername("李云龙");
        user1.setAddress("独立团");
        user1.setPhone("13333333333");
        User user2 = new User();
        user2.setUsername("赵刚");
        user2.setAddress("独立团");
        user2.setPhone("13333333333");
        userMapper2.addUserBatch(Arrays.asList(user1,user2));
    }

    @Test
    void  test9(){
        User userById2 = userMapper2.getUserById2(1L);
        System.out.println(userById2);
    }

    @Test
    void  test10(){
        List<User> userWithBooks = userMapper2.getUserWithBooks();
        for (User userWithBook : userWithBooks) {
            System.out.println(userWithBook);
        }
    }

    @Test
    void  test11(){
        User user1 = new User();
        user1.setUsername("和尚");
        user1.setAddress("独立团");
        user1.setPhone("19999999999");
        user1.setFavorites(Arrays.asList("篮球","健身"));
        userMapper2.addUserTypeHandler(user1);
    }

    @Test
    void  test12(){
        User userById = userMapper2.getUserById(3L);
        System.out.println(userById);
    }

    @Test
    void test13(){
        PageHelper.startPage(1,1);
        List<User> userByList = userMapper2.getUserByList();
        PageInfo<User> us = new PageInfo<>(userByList);
        System.out.println(us.getTotal());
        System.out.println(us.getSize());
        System.out.println(us.getList());
    }

}
