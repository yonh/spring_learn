package dao.impl;

import model.User;

import dao.UserDAO;


public class UserDAOImpl implements UserDAO {
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void save(User user) {
		
		System.out.println("user saved!");
	}
	
	public String toString() {
		return "id:" + this.id;
	}

}
