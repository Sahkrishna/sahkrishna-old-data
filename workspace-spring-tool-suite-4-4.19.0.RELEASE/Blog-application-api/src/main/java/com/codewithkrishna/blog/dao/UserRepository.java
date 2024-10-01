package com.codewithkrishna.blog.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithkrishna.blog.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	

}
