package com.test.redis.token;


import com.test.redis.exception.IdempotentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private RedisService redisService;

    public String createToken() {
        String uuid = UUID.randomUUID().toString();
        redisService.setEx(uuid, uuid, 60L);
        return uuid;
    }

    public boolean checkToken(HttpServletRequest request) throws IdempotentException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                throw new IdempotentException("token 不存在！");
            }
        }
        if (!redisService.exists(token)) {
            throw new IdempotentException("重复操作！");
        }
        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new IdempotentException("重复操作！");
        }
        return true;
    }
}
