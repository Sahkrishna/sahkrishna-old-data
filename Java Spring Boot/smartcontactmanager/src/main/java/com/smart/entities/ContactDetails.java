package com.smart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contact")
public class ContactDetails {
	
	@Id
	@Column(name = "Contact_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cont_id;
	private String name;
	private String nickName;
	private String work;
	@Column(length = 500)
	private String description;
	@Column(length = 10)
	private long phone;
	@Column(unique = true)
	private String email;
	private String image;
	
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCont_id() {
		return cont_id;
	}
	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ContactDetails [cont_id=" + cont_id + ", name=" + name + ", nickName=" + nickName + ", work=" + work
				+ ", description=" + description + ", phone=" + phone + ", email=" + email + ", image=" + image
				+ ", user=" + user + "]";
	}
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
