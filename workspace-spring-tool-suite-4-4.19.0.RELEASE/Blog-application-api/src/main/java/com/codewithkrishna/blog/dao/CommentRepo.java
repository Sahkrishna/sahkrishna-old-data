package com.codewithkrishna.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithkrishna.blog.entity.Comment;
import com.codewithkrishna.blog.entity.Post;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
	List<Comment> findAllByPost(Post post);

}
