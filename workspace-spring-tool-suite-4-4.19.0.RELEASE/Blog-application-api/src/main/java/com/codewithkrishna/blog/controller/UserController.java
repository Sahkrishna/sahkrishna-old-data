 package com.codewithkrishna.blog.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkrishna.blog.payloads.ApiMessage;
import com.codewithkrishna.blog.payloads.UserDto;
import com.codewithkrishna.blog.payloads.UserResponse;
import com.codewithkrishna.blog.services.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post- create user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto user = userService.createUser(userDto);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		
	}
	
	//get --getting the single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer uId){
		
		UserDto user = this.userService.getUserById(uId);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uId){
		
		UserDto updateUser = this.userService.updateUser(uId, userDto);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<UserResponse> getAllUser(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir){
		
		UserResponse userResponse = this.userService.getAllUser(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiMessage> deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiMessage>(new ApiMessage("User deleted succesfully",true), HttpStatus.OK);
	}
	
}
