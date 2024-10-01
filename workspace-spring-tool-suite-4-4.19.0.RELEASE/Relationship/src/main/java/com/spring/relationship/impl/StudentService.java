package com.spring.relationship.impl;

import java.util.List;

import com.spring.relationship.Entity.Student;


public interface StudentService {
	
	//Getting all student
	List<Student> getAllStudent();
	
	Student getStudentById(int studentId);
	
	//updating the student
	Student updateStudent(int studentId, Student Student);
	
	//deleting the student
	void deleteStudent(int studentId);

}
