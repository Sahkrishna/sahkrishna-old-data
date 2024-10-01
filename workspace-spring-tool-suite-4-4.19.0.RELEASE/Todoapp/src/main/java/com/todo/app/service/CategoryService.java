package com.todo.app.service;

import java.util.List;

import com.todo.app.payload.CategoryDto;

public interface CategoryService {
	
	//create --save the category
	
		public CategoryDto createCategory(CategoryDto categoryDto);
		
		//update --updating the category
		
		public CategoryDto updateCategory(Integer categoryId,CategoryDto categoryDto);
		
		//delete-- deleting the category
		
		public void deleteCategory(Integer categoryId);
		
		//get-- getting the single category
		
		public List<CategoryDto> getAllCategory();

		//get all --getting all the user
		
		public CategoryDto getSingleCategory(Integer categoryId);

}
