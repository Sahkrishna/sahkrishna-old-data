package com.spring.relationship.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.relationship.Entity.Student;
import com.spring.relationship.service.StudentServiceImpl;

@RestController
@RequestMapping("/user")
public class StudentController {
	
	private StudentServiceImpl studentService;
	
	
//	@PostMapping("/create")
//	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
//		
//	Student saveStudents = this.studentService.saveStudents(student);
//	
//	return new ResponseEntity<Student>(saveStudents,HttpStatus.CREATED);
//		
//	}
	
//	@GetMapping("/")
//	public List<Student> getAllStudents(){
//		
//		List<Student> allStudent = studentService.getAllStudent();
//		
//		return new
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		
		Student studentById = studentService.getStudentById(id);
		return new ResponseEntity<>(studentById,HttpStatus.FOUND);
	}
	

}
