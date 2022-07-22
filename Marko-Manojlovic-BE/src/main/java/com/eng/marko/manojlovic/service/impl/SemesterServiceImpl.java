package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.dto.SemesterDto;
import com.eng.marko.manojlovic.entity.SemesterEntity;
import com.eng.marko.manojlovic.mapper.SubjectMapStructMapper;
import com.eng.marko.manojlovic.repository.SemesterRepository;
import com.eng.marko.manojlovic.service.SemesterService;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{
	@Autowired
	private SemesterRepository semesterRepository;
	@Autowired
	private SubjectMapStructMapper subjectMapper;
	// ovaj mapper sadrzi metode koje mapiraju semester, da ne bi pisao
	// poseban maper koristim subjectMapper
	
	@Override
	public List<SemesterDto> findAll() {
		List<SemesterEntity> semesters = semesterRepository.findAll();
		return semesters.stream().map(semester -> {
			return subjectMapper.toDto(semester);
		}).collect(Collectors.toList());
	}
}
