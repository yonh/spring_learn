package dao.impl;

import org.springframework.stereotype.Component;

import model.User;

import dao.UserDAO;

@Component
public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
	}

}
