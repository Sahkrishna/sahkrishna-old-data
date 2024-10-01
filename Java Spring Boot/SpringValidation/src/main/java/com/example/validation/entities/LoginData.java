package com.example.validation.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message="username cannot be empty")
	@Size(min = 3,max = 12,message = "Username must be 3-12 character")
	private String userName;
	@Email
	private String email;
	
	@NotBlank(message = "password cannot be empty")
	@Size(min = 5,max = 12,message = "Password must be 5-12 character")
	private String password;
	
	@AssertTrue(message="Must agree terms and condition")
	private boolean agreed;
	public String getPassword() {
		return password;
	}
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName; 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
