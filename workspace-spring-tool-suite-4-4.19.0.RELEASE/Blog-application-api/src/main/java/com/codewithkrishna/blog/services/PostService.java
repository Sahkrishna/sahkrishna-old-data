package com.codewithkrishna.blog.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codewithkrishna.blog.entity.Post;
import com.codewithkrishna.blog.payloads.PostDto;
import com.codewithkrishna.blog.payloads.PostResponse;

public interface PostService {
	
	
	//getting single post
	public PostDto getSinglePost(Integer postDtoId);
	
	//getting the all the post
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//updating the post
	
	public PostDto updatePost(Integer postDtoId,PostDto postDto);
	
	//creating the post
	public PostDto savePost(PostDto postDto,Integer userId,Integer categoryId) throws IOException;
	
	//Deleting the post
	public void deletePost(Integer postDtoId);
	
	//getting the post by category
	public List<PostDto> getPostByCategory(Integer categoryId);
	
	//getting the post by user
	public List<PostDto> getPostByUser(Integer userId);
	
	//searching the post
	public List<PostDto> searchPost(String keyword);

}
