package kz.iitu.spring_lab_01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class TimingAspect {

    @Around("Pointcuts.serviceOperation()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        System.out.println("[TIMING] "
                + joinPoint.getSignature().toShortString()
                + " took " + duration + " ms");

        if (duration > 200) {
            System.out.println("[TIMING] WARNING: slow operation!");
        }

        return result;
    }
}