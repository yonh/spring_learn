package spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import spring.dao.UserDAO;
import spring.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User u) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
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
