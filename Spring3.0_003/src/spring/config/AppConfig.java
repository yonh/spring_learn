package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.UserDao;
import spring.service.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	
	@Bean
	public UserService userService() {
		UserService service = new UserService();
		service.setUserDao(new UserDao());
		return service;
	}
}
