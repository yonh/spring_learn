package service;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import model.User;

import dao.UserDAO;



public class UserService {
	private UserDAO userDAO;  
	public void add(User user) {
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
//	@Autowired
//	public void setUserDAO(@Qualifier("u") UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	
	@Resource
	//@Resource(name="u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
