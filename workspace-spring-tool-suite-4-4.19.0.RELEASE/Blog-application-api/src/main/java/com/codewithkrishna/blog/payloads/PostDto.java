package com.codewithkrishna.blog.payloads;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codewithkrishna.blog.entity.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto { 
	
	private int id;
	
	@NotEmpty
	@Size(min = 6,message = "Enter the more then 6 character") 
	private String title;
	@NotEmpty
	@Size(min = 5 ,max = 50,message = "Content must be 5 to 50 charcter")
	private String content;
	@NotEmpty
	private String image; 
	private Date addedDate;
	private CategoryDto category; 
	private UserDto user;
	
	private Set<CommentDto> comment=new HashSet<>();

}
