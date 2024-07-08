package com.test.mybatis.mapper;

import com.test.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Select("select * from user where id=#{id}")
    User getUserById(Long id);

    @Results({
            @Result(property = "phone", column = "mobile")
    })
    @Select("select * from user")
    List<User> getAllUser();

    @Insert("insert into user (username,address,mobile) values (#{username},#{address},#{phone})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Integer insertUser(User user);

    @Delete("delete from user where id = #{id} ")
    Integer deleteById(Long id);

    @Update(" update user set username = #{username} where id = #{id}")
    Integer updateUserById(String username, Long id);
}
