package org.example.aopwithannotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggableAdvice {

    @Before("@annotation(Loggable) && execution(* *(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Calling " + joinPoint.getSignature());
    }
}
