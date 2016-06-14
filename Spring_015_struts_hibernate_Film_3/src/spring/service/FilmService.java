package spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.dao.FilmDao;

import spring.model.Film;

@Component("filmService")
public class FilmService {
	private FilmDao filmDao;
	
	
	
	public  FilmDao getFilmDao() {
		return filmDao;
	}
	
	@Resource(name="filmDao")
	public  void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}
	public List<Film> getAll() {
		return filmDao.getAll();
	}
	public Film get(int id) {
		System.out.println(filmDao);
		return filmDao.get(id);
	}
	public boolean delete(int id) {
		try {
			filmDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(Film film) {
		try {
			filmDao.update(film);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
