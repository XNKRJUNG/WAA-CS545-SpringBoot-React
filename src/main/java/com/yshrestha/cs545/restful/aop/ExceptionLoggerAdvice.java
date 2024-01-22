package com.yshrestha.cs545.restful.aop;

import com.yshrestha.cs545.restful.entity.aop.ExceptionLogger;
import com.yshrestha.cs545.restful.repository.ExceptionLoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Aspect
@Configuration
public class ExceptionLoggerAdvice {
    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;

    @AfterThrowing(pointcut = "execution(* com.yshrestha.cs545.restful.*.*.*(..))", throwing = "exception")
    public void logAfterThrowingAllMethods(JoinPoint joinPoint, Exception exception) throws Throwable {
        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setDate(LocalDate.now());
        exceptionLogger.setPrincipal("Standard User");
        exceptionLogger.setOperation(joinPoint.getSignature().getName());
        exceptionLogger.setExceptionType(exception.getClass().getName());
        exceptionLogger.setExceptionMessage(exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);

    }
}