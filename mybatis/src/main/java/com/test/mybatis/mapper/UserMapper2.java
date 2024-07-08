package com.test.mybatis.mapper;

import com.test.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {


    User getUserById(Long id);

    List<User> getAllUser();

    Integer insertUser(User user);

    Integer deleteById(Long id);

    Integer updateUserById(String username, Long id);

    List<User> getUserPage(Integer start, Integer size);

    List<User> getUserByCondition(User user);

    Integer updateUser(User user);

    List<User> getUserByIds(List<Long> ids);

    Integer addUserBatch(List<User> users);

    User getUserById2(Long id);
    List<User> getUserWithBooks();

    Integer addUserTypeHandler(User user);

    List<User> getUserByList();

}
