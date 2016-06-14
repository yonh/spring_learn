package spring.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import spring.dao.UserDAO;
import spring.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	public void save(User u) {
		System.out.println("user saved!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init...");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy...");
	}
}
