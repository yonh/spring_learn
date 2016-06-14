package spring.action;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.model.Film;
import spring.service.FilmService;


import com.opensymphony.xwork2.ActionSupport;

public class FilmActionTest {
	@Test
	public void testGet() {
		FilmAction f = new FilmAction();
		f.setId(1);
		String ret = f.execute();
		Assert.assertEquals("success", ret);
	}
}
