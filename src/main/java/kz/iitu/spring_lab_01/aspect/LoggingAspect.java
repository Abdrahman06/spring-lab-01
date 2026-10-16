package kz.iitu.spring_lab_01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("Pointcuts.serviceOperation()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Calling: "
                + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(
            pointcut = "Pointcuts.serviceOperation()",
            returning = "result"
    )
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] Completed: "
                + joinPoint.getSignature().toShortString()
                + " -> " + result);
    }

    @AfterThrowing(
            pointcut = "Pointcuts.serviceOperation()",
            throwing = "ex"
    )
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[LOG] Exception in "
                + joinPoint.getSignature().toShortString()
                + ": " + ex.getMessage());
    }
}