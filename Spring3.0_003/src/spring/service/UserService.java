package spring.service;

import spring.dao.UserDao;

public class UserService {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add() {
		userDao.save();
	}

}
