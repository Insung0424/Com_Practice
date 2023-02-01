package com.JIS.upgradeProject.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class TestAspect {

    @Around(value = "execution(* com.JIS.upgradeProject.service.TestService.*(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = pjp.proceed();
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return retVal;
    }
}
