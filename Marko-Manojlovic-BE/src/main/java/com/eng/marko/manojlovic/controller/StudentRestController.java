package com.eng.marko.manojlovic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.dto.StudentDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentRestController {
	private final StudentService studentService;
	
	public StudentRestController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping(path="all")
	public @ResponseBody ResponseEntity<List<StudentDto>> findAll() {
		return ResponseEntity.ok(studentService.findAllStudents());
	}
	
	@GetMapping(path="{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<StudentDto> studentDto = studentService.findById(id);
		return studentDto.<ResponseEntity<Object>>map(dto -> ResponseEntity.status(HttpStatus.OK).body(dto))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID!"));
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Object> saveStudent(@RequestBody StudentDto studentDto) {
		try {
			StudentDto student = studentService.saveStudent(studentDto);
			return ResponseEntity.status(HttpStatus.OK).body(student);
		} catch (EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
