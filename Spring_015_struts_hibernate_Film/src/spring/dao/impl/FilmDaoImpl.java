package spring.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import spring.dao.FilmDao;
import spring.dao.HibernateUtil;
import spring.model.Film;


@Component("filmDao")
public class FilmDaoImpl implements FilmDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Film> getAll() {
		return hibernateTemplate.find("from Film");
		
//		Session session = HibernateUtil.getCurrentSession();
//		session.beginTransaction();
//		List<Film> list = 
		
//		List<Film> list = (List<Film>) session.createQuery("from Film").list();
//		session.close();
//		
//		return list;
	}

	@Override
	public Film get(int id) {
		List list = hibernateTemplate.find("from Film f where f.id=" + id);
		if (list != null && list.size() > 0) return (Film)list.get(0);
		
		return null;
//		Session session = HibernateUtil.getCurrentSession();
//		session.beginTransaction();
//		
//		Film f = (Film) session.createQuery("from Film f where f.id=" + id).uniqueResult();
//		session.close();
//		
//		return f;
	}

	@Override
	public void delete(int id) {
		Film f = get(id);
		if (f != null) hibernateTemplate.delete(f);
		
//		Session session = HibernateUtil.getCurrentSession();
//		session.beginTransaction();
//		
//		session.createQuery("delete from Film f where f.id=" + id).executeUpdate();
//		
//		session.getTransaction().commit();
	}

	@Override
	public void update(Film film) {
		hibernateTemplate.update(film);
	}
}
