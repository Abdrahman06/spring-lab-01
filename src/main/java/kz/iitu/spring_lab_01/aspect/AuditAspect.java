package kz.iitu.spring_lab_01.aspect;

import kz.iitu.spring_lab_01.audit.Audited;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class AuditAspect {

    @Before("@annotation(audited)")
    public void auditBefore(JoinPoint joinPoint, Audited audited) {

        String message = "[AUDIT] action=" + audited.action()
                + ", method=" + joinPoint.getSignature().toShortString();

        if (audited.logArguments()) {
            message += ", args=" + Arrays.toString(joinPoint.getArgs());
        }

        System.out.println(message);
    }

    @AfterReturning("@annotation(audited)")
    public void auditAfter(JoinPoint joinPoint, Audited audited) {
        System.out.println("[AUDIT] completed action="
                + audited.action());
    }
}