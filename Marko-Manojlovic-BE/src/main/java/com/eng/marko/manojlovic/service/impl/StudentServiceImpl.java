package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.dto.StudentDto;
import com.eng.marko.manojlovic.entity.Student;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.mapper.StudentMapper;
import com.eng.marko.manojlovic.repository.StudentRepository;
import com.eng.marko.manojlovic.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;
	
	public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
		super();
		this.studentRepository = studentRepository;
		this.studentMapper = studentMapper;
	}
	
	
	@Override
	public List<StudentDto> findAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students.stream().map(student -> {
			return studentMapper.toDto(student);
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<StudentDto> findById(Long id) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		if(existingStudent.isPresent()) {
			return Optional.of(studentMapper.toDto(existingStudent.get()));
		}
		return Optional.empty();
	}

	@Override
	public StudentDto saveStudent(StudentDto studentDto) throws EntityExistsException {
		Optional<Student> existingStudent = studentRepository.findById(studentDto.getStudentId());
		if(existingStudent.isPresent()) {
			throw new EntityExistsException(studentDto, "Student with id " + studentDto.getStudentId() + " already exists!");
		} 
		return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentDto)));
	}

	@Override
	public void deleteStudent(Long id) throws InvalidEntityException {
		Optional<Student> student = studentRepository.findById(id);
		
		if(!student.isPresent()) {
			throw new InvalidEntityException(studentMapper.toDto(student.get()), "Invalid entity!");
		}
		
		studentRepository.delete(student.get());
	
	}

	@Override
	public StudentDto updateStudent(StudentDto student) throws InvalidEntityException {
		return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(student)));
	}

}