package org.example.minispringhelloworld.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * @author pdai
 */
@Aspect
public class LogAspect {

    // org.example.minispringhelloworld.service.UserServiceImpl
    /**
     * aspect for every methods under service package.
     */
    @Around("execution(* org.example.minispringhelloworld.service.*.*(..))")
    public Object businessService(ProceedingJoinPoint pjp) throws Throwable {
        // get attribute through annotation
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        System.out.println("execute method: " + method.getName());
        // continue to process
        return pjp.proceed();
    }

}