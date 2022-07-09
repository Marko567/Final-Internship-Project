package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.eng.marko.manojlovic.dto.ProfessorDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;

public interface ProfessorService {
	public List<ProfessorDto> findAllProfessors();
	
	Optional<ProfessorDto> findById(Long id);
	
	public ProfessorDto saveProfessor(ProfessorDto professorDto) throws EntityExistsException;
	
	public void deleteProfessor(Long id) throws InvalidEntityException;
	
	public ProfessorDto updateProfessor(ProfessorDto professor) throws InvalidEntityException;

	Page<ProfessorDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
	List<ProfessorDto> getProfessorsEngagedOnSubject(Long id);
}
