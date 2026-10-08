package kz.iitu.spring_lab_01.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {

    @Pointcut("within(kz.iitu.spring_lab_01.service..*)")
    public void serviceLayer() {
    }

    @Pointcut("execution(* kz.iitu.spring_lab_01.service..*(..))")
    public void serviceOperation() {
    }
}
