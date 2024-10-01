package com.codewithkrishna.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkrishna.blog.payloads.ApiMessage;
import com.codewithkrishna.blog.payloads.CommentDto;
import com.codewithkrishna.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		
		CommentDto comment = this.commentService.saveComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(comment, HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CommentDto>> getAllComment(){
		
		List<CommentDto> allComment = this.commentService.getAllComment();
		
		return new ResponseEntity<List<CommentDto>>(allComment, HttpStatus.OK);
	}
	@GetMapping("/{postId}/comment")
	public ResponseEntity<List<CommentDto>> getCommentByPostId(@PathVariable Integer postId){
		
		List<CommentDto> commentByPostId = this.commentService.getCommentByPostId(postId);
		
		return new ResponseEntity<List<CommentDto>>(commentByPostId, HttpStatus.OK);
	}
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiMessage> deleteComment(@PathVariable Integer commentId){
		
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiMessage>(new ApiMessage("Comment Deleted successfully",true), HttpStatus.OK);
	}

}
