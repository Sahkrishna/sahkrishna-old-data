package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.User;
import com.spring.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/normal")
	public List<User> getAllUsers(){
		
		return this.userService.getAllUser();
	}
	@GetMapping("/normal/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		
		return this.userService.getUserByUserName(userName);
	}
	@PostMapping("/normal")
	public User saveUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser()
	{
		return ResponseEntity.ok("Yes I am a public user");
	}
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("Yes I am a Admin user");
	}

}
