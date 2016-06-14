package spring.dao;

import java.util.List;

import spring.model.Film;

public interface FilmDao {
	public List<Film> getAll();//  获得所有电影
	public Film get(int id);//  获得指定的电影
	public void delete(int id);//  删除指定的电影
	public void update(Film film);// 更新指定的电影
}
