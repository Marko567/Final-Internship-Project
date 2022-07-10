package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import com.eng.marko.manojlovic.entity.Exam;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;

public interface ExamService {
	public List<Exam> findAllExams();
	
	Optional<Exam> findById(Long id);
	
	public Exam saveExam(Exam exam) throws EntityExistsException;
	
	public void deleteExam(Long id) throws InvalidEntityException;
	
	public Exam updateExam(Exam exam) throws InvalidEntityException;

	List<Exam> getExamsFromActiveExamPeriod();
	// Page<ProfessorDto> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
}
