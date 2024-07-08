package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    /**
     * 返回值任意，类任意，方法任意，参数任意
     */
    @Pointcut("execution(* com.test.aop.service.*.*(..))")
    public void pc1() {

    }

    @Before("pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行了。。。。。。");
    }

    @After("pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束了。。。。。。");
    }

    @AfterReturning(value = "pc1()", returning = "s")
    public void afterReturn(JoinPoint jp, String s) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法的返回值是" + s);
    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出了异常" + e.getMessage());
    }

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) {
        try {
            Object proceed = pjp.proceed();
            return proceed;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
