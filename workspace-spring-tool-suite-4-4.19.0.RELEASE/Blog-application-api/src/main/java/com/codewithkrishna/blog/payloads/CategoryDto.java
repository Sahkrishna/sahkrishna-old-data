package com.codewithkrishna.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty(message = "Not be empty")
	@Size(min = 4,message = "Title must be atleast 4 character")
	private String title;
	@NotEmpty(message = "Not be empty")
	@Size(min = 5, max = 20,message = "Description must be between 5- 20 character")
	private String categoryDescription;
}
