package com.todo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
