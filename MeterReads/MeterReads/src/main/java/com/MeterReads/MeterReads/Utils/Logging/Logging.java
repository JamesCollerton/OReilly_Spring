package com.MeterReads.MeterReads.Utils.Logging;

import com.MeterReads.MeterReads.Utils.Timing.MillisTimer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Aspect
@Component
public class Logging {

    private Logger logger = Logger.getLogger(getClass().getName());

    /*
    Logger ideas:
        - Logging around the calls to controllers with time elapsed.
        - Logging around the writing to the database with time elapsed.
     */

    
    @Around("execution(* com.MeterReads.MeterReads..*.*(..))")
    public Object allMethodLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArguments = joinPoint.getArgs();

        logger.info("Entering in Method: " + methodName);
        logger.info("Method Arguments: " + Arrays.stream(methodArguments).map(Object::toString).collect(Collectors.joining(", ")));

        Object returnValue = joinPoint.proceed(methodArguments);

        logger.info("Exiting Method: " + methodName);
        logger.info("Method Return Value: " + returnValue.toString());

        return returnValue;
    }

    /**
     * This provides the logging for all of the controllers so we can monitor when
     * calls are made to the API.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable
     */
    @Around("execution(* com.MeterReads.MeterReads.Controllers..*.*(..))")
    public Object controllerLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Entering in Controller Logging");
        Object returnValue = performanceMonitoringLogging(joinPoint);
        logger.info("Exiting Controller Logging");
        return returnValue;
    }

    /*
    Utilities
     */

    /**
     * This logger can be called whenever we want to monitor the performance of a process.
     * Perhaps we want to see how long it is taking to make API calls or write to the database.
     * This will then log information around that.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable
     */
    private Object performanceMonitoringLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        MillisTimer millisTimer = new MillisTimer();
        millisTimer.start();

//        String methodName = joinPoint.getSignature().getName();
        Object[] methodArguments = joinPoint.getArgs();
//
//        logger.info("Entering in Method: " + methodName);
//        logger.info("Method Arguments: " + Arrays.stream(methodArguments).map(Object::toString).collect(Collectors.joining(", ")));

        Object returnValue = joinPoint.proceed(methodArguments);

        millisTimer.finish();
        long timeElapsed = millisTimer.getTime();

//        logger.info("Exiting Method: " + methodName);
//        logger.info("Method Return Value: " + returnValue.toString());
        logger.info("Elapsed Time (ms): " + timeElapsed);

        return returnValue;
    }

}
