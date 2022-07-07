package com.eng.marko.manojlovic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.ExamPeriodStatus;
import com.eng.marko.manojlovic.repository.ExamPeriodStatusRepository;
import com.eng.marko.manojlovic.service.ExamPeriodStatusService;

@Service
@Transactional
public class ExamPeriodStatusServiceImpl implements ExamPeriodStatusService {
	@Autowired
	private ExamPeriodStatusRepository examPeriodStatusRepository;
	
	@Override
	public List<ExamPeriodStatus> findAll() {
		return examPeriodStatusRepository.findAll();
	}
}
