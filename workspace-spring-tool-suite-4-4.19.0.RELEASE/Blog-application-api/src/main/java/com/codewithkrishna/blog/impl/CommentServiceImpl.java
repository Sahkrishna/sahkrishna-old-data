package com.codewithkrishna.blog.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithkrishna.blog.dao.CommentRepo;
import com.codewithkrishna.blog.dao.PostRepo;
import com.codewithkrishna.blog.entity.Comment;
import com.codewithkrishna.blog.entity.Post;
import com.codewithkrishna.blog.exception.ResourceNotFoundException;
import com.codewithkrishna.blog.payloads.CommentDto;
import com.codewithkrishna.blog.services.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRep;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto saveComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRep.findById(postId).orElseThrow(()->new ResourceNotFoundException("PostId", "id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		
		
		
		Comment save = this.commentRepo.save(comment);
		
		
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public List<CommentDto> getAllComment() {
		
		List<Comment> comments = this.commentRepo.findAll();
		
		List<CommentDto> commentes = comments.stream().map((comment)->this.modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		
		return commentes;
	}

	@Override
	public List<CommentDto> getCommentByPostId(Integer postId) {
		
		Post post = this.postRep.findById(postId).orElseThrow(()->new ResourceNotFoundException("PostId", "id", postId));
		
		List<Comment> allComment = this.commentRepo.findAllByPost(post);
		
		List<CommentDto> collect = allComment.stream().map((comment)->this.modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		 Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("CommentId", "id", commentId));
		
		 this.commentRepo.delete(comment);
	}

}
