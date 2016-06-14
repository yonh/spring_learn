package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


public class LogInterceptor {
	
	
	public void start() {
		System.out.println("start.....");
	}
	
	
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start....");
		pjp.proceed();
		System.out.println("around end....");
	}
	
	
}
