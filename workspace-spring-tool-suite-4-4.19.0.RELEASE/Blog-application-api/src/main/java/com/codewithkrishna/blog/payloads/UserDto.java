package com.codewithkrishna.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min = 4, message = "Username must be 4  character")
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min=5,max=10,message = "Password must be min 5 and max 10 character")
	private String password;
	@NotEmpty
	private String about;

}
