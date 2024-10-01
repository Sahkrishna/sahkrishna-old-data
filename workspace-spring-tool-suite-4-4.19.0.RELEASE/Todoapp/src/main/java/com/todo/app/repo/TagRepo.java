package com.todo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.entity.Tag;

public interface TagRepo extends JpaRepository<Tag, Integer>{

}
