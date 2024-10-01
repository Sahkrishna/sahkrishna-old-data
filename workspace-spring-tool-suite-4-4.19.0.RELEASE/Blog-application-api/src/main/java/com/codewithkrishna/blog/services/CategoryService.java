package com.codewithkrishna.blog.services;

import java.util.List;

import com.codewithkrishna.blog.payloads.CategoryDto;
import com.codewithkrishna.blog.payloads.CategoryResponse;

public interface CategoryService {
	
	//create --save the category
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update --updating the category
	
	public CategoryDto updateCategory(Integer categoryId,CategoryDto categoryDto);
	
	//delete-- deleting the category
	
	public void deleteCategory(Integer categoryId);
	
	//get-- getting the single category
	
	public CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize);

	//get all --getting all the user
	
	public CategoryDto getSingleCategory(Integer categoryId);
	

}
