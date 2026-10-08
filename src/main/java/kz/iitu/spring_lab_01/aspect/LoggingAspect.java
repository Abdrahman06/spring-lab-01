package kz.iitu.spring_lab_01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("execution(* kz.iitu.spring_lab_01.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Calling: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(
            pointcut = "execution(* kz.iitu.spring_lab_01.service..*(..))",
            returning = "result"
    )
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] Completed: "
                + joinPoint.getSignature().toShortString()
                + " -> " + result);
    }
}