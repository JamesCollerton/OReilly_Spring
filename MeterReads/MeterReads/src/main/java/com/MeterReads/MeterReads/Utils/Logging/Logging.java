package com.MeterReads.MeterReads.Utils.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class Logging {

        private Logger logger = Logger.getLogger(getClass().getName());

        @Before("execution(* com.MeterReads.MeterReads..*.*(..))")
        public void logForAllMethods(JoinPoint joinPoint){
            logger.info("Entering in Method :  " + joinPoint.getSignature().getName());
        }

}
