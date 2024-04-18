package com.meli.pssql.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.meli.pssql.handler.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Executing method: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.meli.pssql.handler.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("An error occurred in method: {}", joinPoint.getSignature().getName(), error);
    }

    @AfterThrowing(pointcut = "execution(* com.meli.pssql.services.*.*(..))", throwing = "error")
    public void logAfterThrowings(JoinPoint joinPoint, Throwable error) {
        log.error("An error occurred in method: {}", joinPoint.getSignature().getName(), error);
    }
}