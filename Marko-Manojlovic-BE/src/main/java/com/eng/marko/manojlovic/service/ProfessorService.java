package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import com.eng.marko.manojlovic.dto.ProfessorDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;

public interface ProfessorService {
	public List<ProfessorDto> findAllProfessors();
	
	Optional<ProfessorDto> findById(Long id);
	
	public ProfessorDto saveProfessor(ProfessorDto professorDto) throws EntityExistsException;
	
	public void deleteProfessor(Long id) throws InvalidEntityException;
	
	public ProfessorDto updateProfessor(ProfessorDto professor) throws InvalidEntityException;
}
