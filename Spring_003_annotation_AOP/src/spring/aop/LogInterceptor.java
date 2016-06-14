package spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
	//定义PointCut
	@Pointcut("execution(public * spring.dao..*.*(..))")
	public void myMethod(){};
	
	
	//特定方法
	//@Before("execution(public void spring.dao.impl.UserDAOImpl.save(spring.model.User))")
	//下面dao..*.*表示dao包下的所有子包的所有方法
	//@Before("execution(public * spring.dao..*.*(..))")
	@Before("myMethod()")
	public void save() {
		System.out.println("method start...");
	}
	
	//方法执行返回之后
	@AfterReturning("execution(public * spring.dao..*.*(..))")
	//@AfterReturning("myMethod()")
	public void end() {
		System.out.println("method end...");
	}
	
	
	
	
}
