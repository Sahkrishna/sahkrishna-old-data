package com.codewithkrishna.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithkrishna.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
