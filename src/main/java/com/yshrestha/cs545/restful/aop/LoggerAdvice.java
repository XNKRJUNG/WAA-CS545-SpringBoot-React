package com.yshrestha.cs545.restful.aop;

import com.yshrestha.cs545.restful.entity.aop.Logger;
import com.yshrestha.cs545.restful.repository.LoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Aspect
@Configuration
public class LoggerAdvice {

    @Autowired
    private LoggerRepository loggerRepository;

    @Pointcut("@annotation(com.yshrestha.cs545.restful.aop.LoggerAdvice.ExecutionTime)")
    public void ExecutionTimePointcut() {
    }

    @Around("ExecutionTimePointcut()")
    public Object logAfterGetUserById(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch("");
        sw.start(call.getSignature().getName());

        Object retVal = call.proceed();
        sw.stop();

        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(sw.getLastTaskTimeMillis());
        logger.setPrincipal("Standard User");
        logger.setOperation(call.getSignature().getName());
        loggerRepository.save(logger);

        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Total runtime for this operation \"" + call.getSignature().getName() + "\"  was: " + totalTime + "ms");

        return retVal;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExecutionTime {
    }
}
