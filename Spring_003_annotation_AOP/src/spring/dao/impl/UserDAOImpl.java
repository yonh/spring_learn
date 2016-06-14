package spring.dao.impl;

import org.springframework.stereotype.Component;

import spring.dao.UserDAO;
import spring.model.User;



@Component("userDAO")
public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
	}

}
