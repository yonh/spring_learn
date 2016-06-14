package spring.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import spring.dao.UserDao;

@ContextConfiguration("classpath:beans.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	

	
	@Test
	public void testAdd() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = ctx.getBean("userService", UserService.class);
		service.add();
	}
}
