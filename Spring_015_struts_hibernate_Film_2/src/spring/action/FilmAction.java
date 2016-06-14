package spring.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.model.Film;
import spring.service.FilmService;


import com.opensymphony.xwork2.ActionSupport;


public class FilmAction extends ActionSupport {
	private FilmService filmService;
	private List<Film> list;
	private Film f;
	private int id;
	
	
	
	public FilmAction() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		filmService = (FilmService) ctx.getBean("filmService");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public FilmService getFilmService() {
		return filmService;
	}


	
	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}


	public List<Film> getList() {
		return list;
	}
	public void setList(List<Film> list) {
		this.list = list;
	}
	
	public Film getF() {
		return f;
	}
	public void setF(Film f) {
		this.f = f;
	}
	public String execute() {
		list = filmService.getAll();
		return SUCCESS;
	}
	public String update() {
		filmService.update(f);
		return "update";
	}
	public String updateInput() {
		f = filmService.get(id);
		return "input";
	}
	public String delete() {
		filmService.delete(id);
		return "delete";
	}
	public String detail() {
		f = filmService.get(id);
		return "detail";
	}
}
