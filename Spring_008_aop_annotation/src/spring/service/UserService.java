package spring.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.dao.UserDAO;
import spring.model.User;

@Component("userService")
public class UserService {
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	@Resource(name="userDAO")
	public void setDao(UserDAO userDAO) {
		this.dao = userDAO;
	}
	
	public void add(User u) {
		dao.save(u);
	}
	
}
