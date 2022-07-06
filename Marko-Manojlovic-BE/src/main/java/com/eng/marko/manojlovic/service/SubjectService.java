package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;

public interface SubjectService {
	public List<SubjectDto> findAllSubjects();
	
	Optional<SubjectDto> findById(Long id);
	
	public SubjectDto saveSubject(SubjectDto subjectDto) throws EntityExistsException;
	
	public void deleteSubject(Long id) throws InvalidEntityException;
	
	public SubjectDto updateSubject(SubjectDto subject) throws InvalidEntityException;

	public Page<SubjectDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
}
