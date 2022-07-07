package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.eng.marko.manojlovic.entity.ExamPeriod;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;

public interface ExamPeriodService {
	List<ExamPeriod> findAll();
	
	Optional<ExamPeriod> findById(Long id);
	
	public ExamPeriod saveExamPeriod(ExamPeriod examPeriod) throws EntityExistsException;
	
	public void deleteExamPeriod(Long id) throws InvalidEntityException;
	
	public ExamPeriod updateExamPeriod(ExamPeriod examPeriod) throws InvalidEntityException;

	Page<ExamPeriod> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);

	List<ExamPeriod> findActiveExamPeriods();
}
