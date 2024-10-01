package com.codewithkrishna.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkrishna.blog.impl.CategoryServiceImpl;
import com.codewithkrishna.blog.payloads.ApiMessage;
import com.codewithkrishna.blog.payloads.CategoryDto;
import com.codewithkrishna.blog.payloads.CategoryResponse;
import com.codewithkrishna.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//Getting the single category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId){
		
		CategoryDto singleCategory = this.categoryService.getSingleCategory(categoryId);
		
		return new ResponseEntity<CategoryDto>(singleCategory, HttpStatus.OK);
	}
	
	//saving the category into the database
	@PostMapping("/")
	public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto category = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
	}
	
	//Getting all the category
	@GetMapping("/")
	public ResponseEntity<CategoryResponse> gettingAllCategory(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "3",required = false)Integer pageSize){
		
		 CategoryResponse categoryResponse = this.categoryService.getAllCategory(pageNumber,pageSize);
		
		return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.OK);
	}
	
	//updating the category through the id
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
		
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryId, categoryDto);
		
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}
	//Deleting the category through the id
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiMessage> deleteCategory(@PathVariable Integer categoryId){
		
		this.categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<ApiMessage>(new ApiMessage("Category Deleted Successfully",true), HttpStatus.OK);
		
	}

}
