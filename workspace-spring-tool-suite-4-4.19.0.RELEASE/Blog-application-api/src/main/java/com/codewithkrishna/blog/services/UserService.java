package com.codewithkrishna.blog.services;

import java.util.List;

import com.codewithkrishna.blog.payloads.PostResponse;
import com.codewithkrishna.blog.payloads.UserDto;
import com.codewithkrishna.blog.payloads.UserResponse;

public interface UserService {
	
	//creating the user
	UserDto createUser(UserDto user);
	//getting the user by userId
	UserDto getUserById(Integer userId);
	//updating the user through the userId
	UserDto updateUser(Integer userId,UserDto user);
	//Getting all the user
	UserResponse getAllUser(Integer pageNumber,Integer pagesize,String sortBy,String sortDir);
	//deleting the user through the userId
	void deleteUser(Integer userId);

}
