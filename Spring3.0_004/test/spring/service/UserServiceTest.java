package spring.service;
import spring.model.User;
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import spring.dao.UserDao;

@ContextConfiguration("classpath:beans.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	

	
	@Test
	public void test1() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		String message = (String) exp.getValue();
		System.out.println(message);
	}
	
	@Test
	public void test2() {
		User u = new User();
		u.setName("abc");
		
		EvaluationContext context = new StandardEvaluationContext(u);
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String s1 = (String)exp.getValue(context);
		String s2 = (String)exp.getValue(u);
		System.out.println("s1=" + s1 + " : s2=" + s2);
	}
	
	
}
