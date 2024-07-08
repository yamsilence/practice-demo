package com.test.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.redis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("test", "hello");
    }

    @Test
    void test() throws JsonProcessingException {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //ops.set("test","hello");
        User user = new User();
        user.setUsername("zs");
        user.setAddress("jinan");
        ObjectMapper om = new ObjectMapper();
        String str = om.writeValueAsString(user);
        ops.set("user", str);
    }

}
