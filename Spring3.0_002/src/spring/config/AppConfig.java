package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.UserDao;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
}
