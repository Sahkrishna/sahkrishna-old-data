package com.todo.app.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.todo.app.entity.Category;
import com.todo.app.exception.ResourceNotFoundException;
import com.todo.app.payload.CategoryDto;
import com.todo.app.repo.CategoryRepo;
import com.todo.app.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category save = this.categoryRepo.save(modelMapper.map(categoryDto, Category.class));
		return this.modelMapper.map(save, CategoryDto.class);

	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryDto", "Id", categoryId));

		category.setName(categoryDto.getName());

		Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("CategoryDto", "Id", categoryId));

		this.categoryRepo.delete(category);

	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategory = this.categoryRepo.findAll();
		List<CategoryDto> selectAllCategory = allCategory.stream().map(categories -> this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		return selectAllCategory;
	}

	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("CategoryDto", "Id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
