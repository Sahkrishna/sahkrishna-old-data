package com.codewithkrishna.blog.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codewithkrishna.blog.dao.CategoryRepo;
import com.codewithkrishna.blog.entity.Category;
import com.codewithkrishna.blog.exception.ResourceNotFoundException;
import com.codewithkrishna.blog.payloads.CategoryDto;
import com.codewithkrishna.blog.payloads.CategoryResponse;
import com.codewithkrishna.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	//saving the category
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category save = this.categoryRepo.save(modelMapper.map(categoryDto, Category.class));
		return this.modelMapper.map(save, CategoryDto.class);
	}
	
	//updating the category

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
		 Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("CategoryDto", "Id", categoryId));
		 
		 category.setTitle(categoryDto.getTitle());
		 category.setCategoryDescription(categoryDto.getCategoryDescription());
		 
		 Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory,CategoryDto.class);
	}
	
	//deleting the category

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryDto", "Id", categoryId));
		
		this.categoryRepo.delete(category);

	}
	
	//getting all th user

	@Override
	public CategoryResponse getAllCategory(Integer pageNumber,Integer pageSize) {
		
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		
		Page<Category> cateResponse = this.categoryRepo.findAll(pageRequest);
		
		List<Category> allCategory = cateResponse.getContent();
		
//		List<Category> allCategory = this.categoryRepo.findAll();
		
		List<CategoryDto> selectAllCategory = allCategory.stream().map(categories -> this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		
		CategoryResponse categoryResponse=new CategoryResponse();
		
		categoryResponse.setContent(selectAllCategory);
		categoryResponse.setLastPage(cateResponse.isLast());
		categoryResponse.setPageNumber(cateResponse.getNumber());
		categoryResponse.setPageSize(cateResponse.getSize());
		categoryResponse.setTotalElement(cateResponse.getTotalElements());
		categoryResponse.setTotalPage(cateResponse.getTotalPages());
		
		return categoryResponse;
	}

	//getting the single category
	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryDto", "Id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
