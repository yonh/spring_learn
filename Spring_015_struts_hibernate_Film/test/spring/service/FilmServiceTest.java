package spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.model.Film;
import spring.service.FilmService;



public class FilmServiceTest {
//	private static FilmService service = new FilmService();
//	@Test
//	public void testGetAll() {
//		List list = service.getAll();
//		assertEquals(3, list.size());
//	}
//	
//	@Test
//	public void testGet() {
//		System.out.println(service);
//		System.out.println(service.getFilmDao());
//		Film f = service.get(1);
//		assertEquals("填埋传齐", f.getName());
//	}
//	@Test
//	public void testDelete() {
//		
//	}
//	@Test
//	public void testUpdate() {
//		Film f = service.get(2);
//		f.setName("填埋传齐2");
//		service.update(f);
//		
//		Film f2 = service.get(2);
//		
//		assertEquals("填埋传齐2", f2.getName());
//	}
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		FilmService filmService = (FilmService) ctx.getBean("filmService");
		System.out.println(filmService);
	}
}
