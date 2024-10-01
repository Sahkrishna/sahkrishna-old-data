package com.codewithkrishna.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithkrishna.blog.dao.UserRepository;
import com.codewithkrishna.blog.entity.User;
import com.codewithkrishna.blog.exception.ResourceNotFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException(username, "Email"+username, 0));
		return user;
	}

}
