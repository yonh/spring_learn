package spring.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.LogDAO;
import spring.dao.UserDAO;
import spring.model.Log;
import spring.model.User;

@Component("userService")
public class UserService {
	private UserDAO userDAO;
	private LogDAO logDAO;
	

	public LogDAO getLogDAO() {
		return logDAO;
	}

	@Resource(name="logDAO")
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
	
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	
	
	//@Transactional
	public void add(User u) {
		userDAO.save(u);
		Log l = new Log();
		l.setMsg(u.getName() + " is saved!");
		logDAO.save(l);
	}
	
}
