package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.model.User;

@Service
public class UserService {
	
	List<User> list=new ArrayList<>();
	
	
	
	public UserService() {
		
		list.add(new User("krishna sah","abc","krishnashah4214@gmail.com"));
		list.add(new User("Balram sah","XYZ","balramsah@gmail.com"));
	}



	//getting all the user
	public List<User> getAllUser(){
		
		return this.list;
	}
	//getting the single user
	public User getUserByUserName(String UserName) {
		
		return this.list.stream().filter((user)->user.getUsername().equals(UserName)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		
		this.list.add(user);
		return user; 
	}

}
