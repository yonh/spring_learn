package spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import spring.dao.LogDAO;
import spring.dao.UserDAO;
import spring.model.Log;
import spring.model.User;

@Component("logDAO")
public class LogDAOImpl extends SuperDAO implements LogDAO {

	
	@Override
	public void save(Log l) {
		this.getHibernateTemplate().save(l);
	}
}