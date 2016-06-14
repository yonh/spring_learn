package service;

import Dao.UserDao;
import model.User;

public class UserService {
	private UserDao dao = new UserDao();
	public void save(User user) {
		dao.save(user);
	}
}
