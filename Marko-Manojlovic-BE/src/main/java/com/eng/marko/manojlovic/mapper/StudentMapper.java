package com.eng.marko.manojlovic.mapper;

import org.springframework.stereotype.Component;

import com.eng.marko.manojlovic.dto.StudentDto;
import com.eng.marko.manojlovic.entity.Student;

@Component
public class StudentMapper {	
	public Student toEntity(StudentDto dto) {
		return new Student(dto.getStudentId(), dto.getIndexNumber(),
				dto.getIndexYear(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), 
				dto.getAddress(), dto.getPostalCode(), dto.getCurrentYearOfStudy());
	}
	
	public StudentDto toDto(Student entity) {
		return new StudentDto(entity.getStudentId(), entity.getIndexNumber(),
				entity.getIndexYear(), entity.getFirstname(), entity.getLastname(), entity.getEmail(), 
				entity.getAddress(), entity.getPostalCode(), entity.getCurrentYearOfStudy());
	}
}
