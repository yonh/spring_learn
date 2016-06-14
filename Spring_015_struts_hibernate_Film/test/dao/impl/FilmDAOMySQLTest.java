package dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import spring.dao.impl.FilmDAOMySQL;
import spring.model.Film;



public class FilmDAOMySQLTest {
	private static FilmDAOMySQL dao = new FilmDAOMySQL();
	@Test
	public void testGetAll() {
		List list = dao.getAll();
		assertEquals(3, list.size());
	}
	
	@Test
	public void testGet() {
		Film f = dao.get(1);
		assertEquals("填埋传奇", f.getName());
	}
	@Test
	public void testDelete() {
		
	}
	@Test
	public void testUpdate() {
		Film f = dao.get(1);
		f.setName("填埋传齐");
		dao.update(f);
		
		Film f2 = dao.get(1);
		
		assertEquals("填埋传齐", f2.getName());
	}
}
