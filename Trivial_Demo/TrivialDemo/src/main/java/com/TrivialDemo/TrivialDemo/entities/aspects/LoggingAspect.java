package com.TrivialDemo.TrivialDemo.entities.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Remember, need to add component to be included in component scan
 */
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(void com.TrivialDemo..*.set*(*))")
    public void callSetters(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", "));
        logger.info("Called " + method + " with args " + arg + " on " + joinPoint.getTarget());
    }

//    @Around("execution(* com.TrivialDemo..*(..))")
//    public Object callMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        // Get information
//        String method = proceedingJoinPoint.getSignature().getName();
//        String arg = Arrays.stream(proceedingJoinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", "));
//        String target = proceedingJoinPoint.getTarget().toString();
//
//        // Log on the way in
//        logger.info("Calling " + method + " with args " + arg + " on " + target);
//
//        Object retVal = proceedingJoinPoint.proceed();
//
//        // Log on the way out
//        logger.info("Called " + method + " with args " + arg + " on " + target);
//
//        return retVal;
//    }

}
