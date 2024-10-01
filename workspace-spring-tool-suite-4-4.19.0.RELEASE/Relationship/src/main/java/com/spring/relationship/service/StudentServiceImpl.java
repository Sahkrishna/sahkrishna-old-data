package com.spring.relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.relationship.Entity.Laptop;
import com.spring.relationship.Entity.Student;
import com.spring.relationship.impl.StudentService;
import com.spring.relationship.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> allStudent = studentRepo.findAll();
		return null;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = studentRepo.getReferenceById(studentId);
		return student;
	}

	@Override
	public Student updateStudent(int studentId, Student Student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
