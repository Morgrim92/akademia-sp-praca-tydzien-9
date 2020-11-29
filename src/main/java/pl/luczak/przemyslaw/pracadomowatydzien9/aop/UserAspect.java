package pl.luczak.przemyslaw.pracadomowatydzien9.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    long start, finish;

    @Before("@annotation(pl.luczak.przemyslaw.pracadomowatydzien9.aop.UserAnnotation)")
    public void startTime(JoinPoint joinPoint) {
        start = System.nanoTime();
    }

    @After("@annotation(pl.luczak.przemyslaw.pracadomowatydzien9.aop.UserAnnotation)")
    public void finishTime(JoinPoint joinPoint) {
        finish = System.nanoTime();
        System.out.println((finish - start) / 1000000);
    }

}
