package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.Exam;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.repository.ExamRepository;
import com.eng.marko.manojlovic.service.ExamService;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamRepository examRepository;
	
	@Override
	public List<Exam> findAllExams() {
		return this.examRepository.findAll();
	}

	@Override
	public Optional<Exam> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exam saveExam(Exam exam) throws EntityExistsException {
		return this.examRepository.save(exam);
	}

	@Override
	public void deleteExam(Long id) throws InvalidEntityException {
		
	}

	@Override
	public Exam updateExam(Exam exam) throws InvalidEntityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> getExamsFromActiveExamPeriod() {
		return examRepository.getExamsFromActiveExamPeriod();
	}
}
