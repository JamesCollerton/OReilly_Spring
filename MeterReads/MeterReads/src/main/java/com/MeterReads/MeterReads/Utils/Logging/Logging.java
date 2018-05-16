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

        /*
        Logger ideas:
            - Logging around the calls to controllers with time elapsed.
            - Logging around the writing to the database with time elapsed.
         */

        @Before("execution(* com.MeterReads.MeterReads.Controllers..*.*(..))")
        public void logForAllMethods(JoinPoint joinPoint){
            logger.info("Entering in Method :  " + joinPoint.getSignature().getName());
        }

}
