package com.codewithkrishna.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithkrishna.blog.entity.Category;
import com.codewithkrishna.blog.entity.Post;
import com.codewithkrishna.blog.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	 List<Post> findAllByUser(User user);
	 List<Post> findAllByCategory(Category category);
	 
	 List<Post> findByTitleContaining(String keyword);

}
