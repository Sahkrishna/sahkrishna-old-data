package com.codewithkrishna.blog.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.codewithkrishna.blog.config.ConstantValue;
import com.codewithkrishna.blog.payloads.ApiMessage;
import com.codewithkrishna.blog.payloads.PostDto;
import com.codewithkrishna.blog.payloads.PostResponse;
import com.codewithkrishna.blog.services.FileService;
import com.codewithkrishna.blog.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
	
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}") 
	private String path;
	

	
	@Autowired
	private PostService postService;
	
	@Autowired
	ObjectMapper mapper;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId) throws IOException
	{
		
		
		PostDto post = this.postService.savePost(postDto, userId, categoryId);
		
		
		
		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.FOUND);
		
	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		
		List<PostDto> postByUser = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.FOUND);
	}
	
	//Getting the single post
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
		
		PostDto singlePost = this.postService.getSinglePost(postId);
		
		return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK);
		
	}
	//getting all the post
	@GetMapping("/post/")
	public ResponseEntity<PostResponse> getAllPosts(
			
			@RequestParam(value="pageNumber",defaultValue =ConstantValue.PAGE_NUMBER ,required = false)Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = ConstantValue.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = ConstantValue.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = ConstantValue.PAGE_SIZE,required = false) String sortDir
			){
		
		PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}
	
	//updating the post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto updatePost = this.postService.updatePost(postId, postDto);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}
	//deleting the post 
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiMessage> deletingPost(@PathVariable Integer postId){
		
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiMessage>(new ApiMessage("Post deleted successfully",true), HttpStatus.OK);
	}
	
	//searching the post
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchingPost(@PathVariable String keyword){
		List<PostDto> searchPost = this.postService.searchPost(keyword);
		
		return new ResponseEntity<List<PostDto>>(searchPost, HttpStatus.FOUND);
		
	}
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadImage(@RequestParam("image") MultipartFile file,@PathVariable Integer postId) throws IOException{
		
		PostDto postDto = this.postService.getSinglePost(postId);
		String fileName = this.fileService.uploadImage(path, file);
		
		
		
		postDto.setImage(fileName);
		
		PostDto updatePost = this.postService.updatePost(postId, postDto);
		
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
		
		
	}
	@GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
		public void downloadImage(@PathVariable("imageName") String imageName,
				HttpServletResponse response) throws IOException {
		
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		org.springframework.util.StreamUtils.copy(resource, response.getOutputStream());
	}
}
