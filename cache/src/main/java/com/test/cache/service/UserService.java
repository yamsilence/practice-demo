package com.test.cache.service;


import com.test.cache.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "c1")
public class UserService {


    @Cacheable(cacheNames = "c1")
    public User getUserById(Long id) {
        System.out.println("getUserById");
        User user = new User();
        user.setId(id);
        user.setName("tom");
        return user;
    }

    // @Cacheable(cacheNames = "c1")
    //  @Cacheable(cacheNames = "c1",key = "#id")
    // @Cacheable(cacheNames = "c1",key = "#root.method.name")
    @Cacheable(cacheNames = "c1", keyGenerator = "myKeyGenerator")
    public User getUserById2(Long id, String name) {
        System.out.println("getUserById");
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @CachePut(cacheNames = "c1", key = "#user.id")
    public User updateUser(User user) {
        return user;
    }


    @CacheEvict(cacheNames = "c1")
    public void deleteUser(Long id) {
        System.out.println("deleteUser");
    }


}
