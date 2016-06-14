package spring.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import spring.dao.UserDao;

@ContextConfiguration("classpath:beans.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Test
	public void testAdd() {
		userDao.save();
	}
	
	@Test
	public void testAdd2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = ctx.getBean("userDao", UserDao.class);//使用泛型，不用强制类型转换
		System.out.println(userDao);
	}
}
