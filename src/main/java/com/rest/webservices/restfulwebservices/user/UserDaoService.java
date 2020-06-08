package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"Goncalo",new Date()));
		users.add(new User(2,"Santos",new Date()));
		users.add(new User(3,"Miranda",new Date()));
	}

	public List<User> findAll(){
		return users;
	}
	
	public User save(User u){
		if(u.getId() == null) {
			u.setId(++usersCount);
		}
		users.add(u);
		return u;
		
	}
	
	public User findById(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public void delete(int id) {
		for(User user : users) {
			if(user.getId() == id)
				users.remove(user);
		}
		
	}
	
}
