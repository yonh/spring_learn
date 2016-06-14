package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.dao.UserDAO;

import spring.model.User;
import spring.service.UserService;





public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		UserService service = (UserService)applicationContext.getBean("userService");
		
		
		User u = new User();
		u.setId(1);
		u.setName("aaa");
		service.add(u);
		
		applicationContext.close();
	}

}
