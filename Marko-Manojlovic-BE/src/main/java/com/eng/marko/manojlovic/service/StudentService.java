package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.domain.Page;

import com.eng.marko.manojlovic.dto.StudentDto;
//import com.eng.marko.manojlovic.entity.Student;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;


public interface StudentService {
	List<StudentDto> findAllStudents();
    
    //Page<StudentDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);

   // List<StudentDto> findOnlySomeStudents(int number);

    Optional<StudentDto> findById(Long id);

    StudentDto saveStudent(StudentDto studentDto) throws EntityExistsException;

    void deleteStudent(Long id) throws InvalidEntityException;

    StudentDto updateStudent(StudentDto student) throws InvalidEntityException;
}
