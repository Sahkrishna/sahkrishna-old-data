package com.todo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.entity.Blog;

public interface BlogRepo extends JpaRepository<Blog, Integer>{

}
