package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.entity.Subject;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.mapper.SubjectMapStructMapper;
import com.eng.marko.manojlovic.repository.SubjectRepository;
import com.eng.marko.manojlovic.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SubjectMapStructMapper subjectMapper;
	
//	public SubjectServiceImpl(SubjectRepository subjectRepository) {
//		super();
//		this.subjectRepository = subjectRepository;
//	}

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
		//return subjectMapper.toDtoNoId(subjectRepository.save(subjectMapper.toEntityNoId(subjectDto)));
		return null;
	}

	@Override
	public void deleteSubject(Long id) throws InvalidEntityException {
		Optional<Subject> subject = subjectRepository.findById(id);
		
		if(!subject.isPresent()) {
			throw new InvalidEntityException(subjectMapper.toDto(subject.get()), "Invalid Entity!");
		}
		
		subjectRepository.delete(subject.get());
	}

	@Override
	public SubjectDto updateSubject(SubjectDto subject) throws InvalidEntityException {
		if(subjectRepository.existsById(subject.getSubjectId())) {
			return subjectMapper.toDto(subjectRepository.save(subjectMapper.toEntity(subject)));
		}
		throw new InvalidEntityException(subject, "Takav predmet ne postoji");
	}

	@Override
	public Page<SubjectDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Sort.Direction direction = "asc".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC;
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(direction, sortBy));

		Page<SubjectDto> entites = subjectRepository.findAll(pageable).map(subjectMapper::toDto);
		return entites;
	}

}
