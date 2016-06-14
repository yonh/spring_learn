package service;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.User;

import dao.UserDAO;


public class UserService {
	private List lists;
	private Set sets;
	private Map<String,String> maps;
	
	
	
	public List getLists() {
		return lists;
	}



	public void setLists(List lists) {
		this.lists = lists;
	}



	public Set getSets() {
		return sets;
	}



	public void setSets(Set sets) {
		this.sets = sets;
	}



	public Map<String, String> getMaps() {
		return maps;
	}



	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}



	public String toString() {
		return "UserService(lists:" + lists.size() + ",sets:" + sets.size() + ",maps:" + maps.size() + ")";
	}
}
