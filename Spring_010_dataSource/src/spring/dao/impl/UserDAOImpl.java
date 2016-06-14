package spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import spring.dao.UserDAO;
import spring.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(User u) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			conn.createStatement().executeUpdate("insert into spring values(1,'aa')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
