package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.entity.Subject;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.mapper.SubjectMapper;
import com.eng.marko.manojlovic.repository.SubjectRepository;
import com.eng.marko.manojlovic.service.SubjectService;



@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	private final SubjectRepository subjectRepository;
	private final SubjectMapper subjectMapper;
	
	public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
		super();
		this.subjectRepository = subjectRepository;
		this.subjectMapper = subjectMapper;
	}
	
	@Override
	public List<SubjectDto> findAllSubjects() {
		List<Subject> subjects = subjectRepository.findAll();
		return subjects.stream().map(subject -> {
			return subjectMapper.toDto(subject);
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<SubjectDto> findById(Long id) {
		Optional<Subject> existingSubject = subjectRepository.findById(id);
		if(existingSubject.isPresent()) {
			return Optional.of(subjectMapper.toDto(existingSubject.get()));
		}
		return Optional.empty();
	}

	@Override
	public SubjectDto saveSubject(SubjectDto subjectDto) throws EntityExistsException {
//		Optional<Student> existingStudent = studentRepository.findById(studentDto.getStudentId());
//		if(existingStudent.isPresent()) {
//			throw new EntityExistsException(studentDto, "Student with id " + studentDto.getStudentId() + " already exists!");
//		} 
		return subjectMapper.toDtoNoId(subjectRepository.save(subjectMapper.toEntityNoId(subjectDto)));
	}

	@Override
	public void deleteSubject(Long id) throws InvalidEntityException {
		Optional<Subject> subject = subjectRepository.findById(id);
		
		if(!subject.isPresent()) {
			throw new InvalidEntityException(subjectMapper.toDto(subject.get()), "Invalid entity!");
		}
		
		subjectRepository.delete(subject.get());
	
	}

	@Override
	public SubjectDto updateSubject(SubjectDto subject) throws InvalidEntityException {
		if(subjectRepository.existsById(subject.getSubjectId())) {
			return subjectMapper.toDto(subjectRepository.save(subjectMapper.toEntity(subject)));
		}
		throw new InvalidEntityException(subject, "Takav predmet ne postoji!");
	}
}