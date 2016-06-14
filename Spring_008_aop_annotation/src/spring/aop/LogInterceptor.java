package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInterceptor {
	
	@Before("mm()")
	public void start() {
		System.out.println("start.....");
	}
	
	@Around("mm()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start....");
		pjp.proceed();
		System.out.println("around end....");
	}
	
	@Pointcut("execution(public void spring.dao.UserDAO.save(spring.model.User))")
	public void mm(){};
}
