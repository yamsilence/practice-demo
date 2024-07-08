package com.test.redis.interceptor;

import com.test.redis.anno.AutoIdempotent;
import com.test.redis.exception.IdempotentException;
import com.test.redis.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;


@Component
public class IdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        AutoIdempotent annotation = method.getAnnotation(AutoIdempotent.class);
        if (annotation != null) {
            try {
                return tokenService.checkToken(request);
            } catch (IdempotentException e) {
                throw e;
            }
        }
        return true;
    }
}
