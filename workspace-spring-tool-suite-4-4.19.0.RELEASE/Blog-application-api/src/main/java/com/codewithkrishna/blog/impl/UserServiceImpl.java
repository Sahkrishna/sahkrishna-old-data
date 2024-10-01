package com.codewithkrishna.blog.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithkrishna.blog.dao.UserRepository;
import com.codewithkrishna.blog.entity.User;
import com.codewithkrishna.blog.exception.ResourceNotFoundException;
import com.codewithkrishna.blog.payloads.PostResponse;
import com.codewithkrishna.blog.payloads.UserDto;
import com.codewithkrishna.blog.payloads.UserResponse;
import com.codewithkrishna.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = this.userRepo.save(user);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserResponse getAllUser(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		
		Sort sort=null;
		if(sortBy.equalsIgnoreCase("asc")) {
			sort=Sort.by(sortBy).ascending();
			
		}
		else {
			sort=Sort.by(sortBy).descending();
		}
		
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,sort);
		
		Page<User> pageUser = this.userRepo.findAll(pageRequest);
		
		List<User> allUser = pageUser.getContent();
		List<UserDto> userDto = allUser.stream().map((users)->this.modelMapper.map(users, UserDto.class)).collect(Collectors.toList());
		
		UserResponse userResponse=new UserResponse();
		userResponse.setContent(userDto);
		userResponse.setPageNumber(pageUser.getNumber());
		userResponse.setPageSize(pageUser.getSize());
		userResponse.setTotalElement(pageUser.getTotalElements());
		userResponse.setTotalPage(pageUser.getTotalPages());
		userResponse.setLastPage(pageUser.isLast());
		
		return userResponse;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		this.userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
		
		return user;	
	}
	
	public UserDto userToDto(User user) {
		
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setName(user.getName());
		
		return userDto;
	}

}
