package com.spring.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.relationship.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
