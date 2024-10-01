package com.codewithkrishna.blog.services;

import java.util.List;

import com.codewithkrishna.blog.payloads.CommentDto;

public interface CommentService {
	
	public CommentDto saveComment(CommentDto commentDto,Integer postId);
	
	public List<CommentDto> getAllComment();
	
	public List<CommentDto> getCommentByPostId(Integer postId);
	
	public void deleteComment(Integer commentId);

}
