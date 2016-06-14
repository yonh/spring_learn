package com.bjsxt.service;
import model.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;



import dao.UserDAO;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		UserService service = (UserService)applicationContext.getBean("userService");
		System.out.println(service);
	}

}
