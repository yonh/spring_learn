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

import spring.dao.LogDAO;
import spring.model.Log;
import spring.model.User;

@Component("logDAO")
public class LogDAOImpl implements LogDAO {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Log u) {
		Session s = sessionFactory.getCurrentSession();
		
		s.save(u);
		//throw new RuntimeException();
	}
	
	
}
