package com.eng.marko.manojlovic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.SemesterEntity;
import com.eng.marko.manojlovic.repository.SemesterRepository;
import com.eng.marko.manojlovic.service.SemesterService;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{
	@Autowired
	private SemesterRepository semesterRepository;

	@Override
	public List<SemesterEntity> findAll() {
		return semesterRepository.findAll();
	}
}
