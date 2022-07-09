package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.dto.ProfessorDto;
import com.eng.marko.manojlovic.entity.Professor;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.mapper.ProfessorMapper;
import com.eng.marko.manojlovic.repository.ProfessorRepository;
import com.eng.marko.manojlovic.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
	private final ProfessorRepository professorRepository;
	private final ProfessorMapper professorMapper;
	
	public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
		super();
		this.professorRepository = professorRepository;
		this.professorMapper = professorMapper;
	}
	
	
	@Override
	public List<ProfessorDto> findAllProfessors() {
		List<Professor> professors = professorRepository.findAll();
		return professors.stream().map(professor -> {
			return professorMapper.toDto(professor);
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<ProfessorDto> findById(Long id) {
		Optional<Professor> existingProfessor = professorRepository.findById(id);
		if(existingProfessor.isPresent()) {
			return Optional.of(professorMapper.toDto(existingProfessor.get()));
		}
		return Optional.empty();
	}

	@Override
	public ProfessorDto saveProfessor(ProfessorDto professorDto) throws EntityExistsException {
		return professorMapper.toDtoNoId(professorRepository.save(professorMapper.toEntityNoId(professorDto)));
	}

	@Override
	public void deleteProfessor(Long id) throws InvalidEntityException {
		Optional<Professor> professor = professorRepository.findById(id);
		
		if(!professor.isPresent()) {
			throw new InvalidEntityException(professorMapper.toDto(professor.get()), "Invalid entity passed!");
		}
		professorRepository.delete(professor.get());
	}

	@Override
	public ProfessorDto updateProfessor(ProfessorDto professor) throws InvalidEntityException {
		if(professorRepository.existsById(professor.getProfessorId())) {
			return professorMapper.toDto(professorRepository.save(professorMapper.toEntity(professor)));
		}
		throw new InvalidEntityException(professor, "Takav professor ne postoji!");
	}
	
	@Override
	public Page<ProfessorDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Sort.Direction direction = "asc".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC;
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(direction, sortBy));

		Page<ProfessorDto> entites = professorRepository.findAll(pageable).map(professorMapper::toDto);
		return entites;
	}


	@Override
	public List<ProfessorDto> getProfessorsEngagedOnSubject(Long id) {
		List<Professor> professors = professorRepository.getProfessorsEngagedOnSubject(id);
		
		return professors.stream().map(professor -> {
			return professorMapper.toDto(professor);
		}).collect(Collectors.toList());
	}

}
