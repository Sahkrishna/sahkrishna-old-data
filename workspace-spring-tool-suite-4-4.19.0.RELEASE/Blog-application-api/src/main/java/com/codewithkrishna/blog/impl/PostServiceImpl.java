package com.codewithkrishna.blog.impl;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithkrishna.blog.dao.CategoryRepo;
import com.codewithkrishna.blog.dao.PostRepo;
import com.codewithkrishna.blog.dao.UserRepository;
import com.codewithkrishna.blog.entity.Category;
import com.codewithkrishna.blog.entity.Post;
import com.codewithkrishna.blog.entity.User;
import com.codewithkrishna.blog.exception.ResourceNotFoundException;
import com.codewithkrishna.blog.payloads.CategoryDto;
import com.codewithkrishna.blog.payloads.PostDto;
import com.codewithkrishna.blog.payloads.PostResponse;
import com.codewithkrishna.blog.services.FileService;
import com.codewithkrishna.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private FileService fileServie;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	
	//getting the post by post Id
	@Override
	public PostDto getSinglePost(Integer postDtoId) {
		
		Post post = this.postRepo.findById(postDtoId).orElseThrow(()->new ResourceNotFoundException("Post Id", "Id", postDtoId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	//getting all the post
	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort=Sort.by(sortBy).ascending();
		}
		else {
			sort=Sort.by(sortBy).descending();
		}
		
		PageRequest of = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post> pagePost = this.postRepo.findAll(of);
		
		List<Post> allPosts = pagePost.getContent();
		
		List<PostDto> postDto = allPosts.stream().map((posts)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		
		
		
		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize()); 
		postResponse.setTotalPage(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		
		return postResponse;
	}
	
	//updating the post

	@Override
	public PostDto updatePost(Integer postDtoId, PostDto postDto) {
		
		Post post = this.postRepo.findById(postDtoId).orElseThrow(()->new ResourceNotFoundException("PostId", "id", postDtoId));
		
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setImage(postDto.getImage());
		
		Post post2 = this.postRepo.save(post);
		
		return this.modelMapper.map(post2, PostDto.class);
	}
	
	//saving the post to the database
	

	@Override
	public PostDto savePost(PostDto postDto, Integer userId, Integer categoryId) throws IOException {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user); 
		post.setImage("default.jpg");
		
		
		
		Post save = this.postRepo.save(post);
		
		return this.modelMapper.map(save, PostDto.class);
	}
	
	//deleting the post

	@Override
	public void deletePost(Integer postDtoId) {
		
		Post post = this.postRepo.findById(postDtoId).orElseThrow(()->new ResourceNotFoundException("Post Id", "Id", postDtoId));
		
		this.postRepo.delete(post);

	}
	
	//getting the post by category

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ID", "Id",categoryId ));
		
		List<Post> allPost = this.postRepo.findAllByCategory(category);
	
		
		List<PostDto> PostDto = allPost.stream().map((posts)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		
		
		return PostDto;
	}
	
	//getting the post by user

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId", "id", userId));
		
		List<Post> allUser = this.postRepo.findAllByUser(user);
		
		
		
		List<PostDto> postDto = allUser.stream().map((users)->this.modelMapper.map(users, PostDto.class)).collect(Collectors.toList());
				
		
		return postDto;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		
		List<Post> posts = this.postRepo.findByTitleContaining(keyword);
		
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

}
