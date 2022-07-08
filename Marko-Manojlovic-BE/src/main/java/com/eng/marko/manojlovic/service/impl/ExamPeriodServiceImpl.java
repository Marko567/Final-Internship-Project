package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.ExamPeriod;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.repository.ExamPeriodRepository;
import com.eng.marko.manojlovic.service.ExamPeriodService;

@Service
@Transactional
public class ExamPeriodServiceImpl implements ExamPeriodService {
	@Autowired
	private ExamPeriodRepository examPeriodRepository;
	
	@Override
	public List<ExamPeriod> findAll() {
		return this.examPeriodRepository.findAll();
	}

	@Override
	public Optional<ExamPeriod> findById(Long id) {
		return this.examPeriodRepository.findById(id);
	}

	@Override
	public ExamPeriod saveExamPeriod(ExamPeriod examPeriod) throws EntityExistsException {
		ExamPeriod em = this.examPeriodRepository.findActiveExamPeriods();
		
		if(em != null && (examPeriod.getExamPeriodStatus().getStatusId() == 1)) {
			throw new EntityExistsException(examPeriod, "At least one ExamPeriod with status: ACTIVE is already present in the database");
		}
		return this.examPeriodRepository.save(examPeriod);
	}

	@Override
	public void deleteExamPeriod(Long id) throws InvalidEntityException {
		Optional<ExamPeriod> examPeriod = this.examPeriodRepository.findById(id);
		
		if(!examPeriod.isPresent()) {
			throw new InvalidEntityException(examPeriod.get(), "Invalid entity passed!");
		}
		this.examPeriodRepository.delete(examPeriod.get());
	}

	@Override
	public ExamPeriod updateExamPeriod(ExamPeriod examPeriod) throws InvalidEntityException, EntityExistsException {
		ExamPeriod em = this.examPeriodRepository.findActiveExamPeriods();
		
		if(em != null && (examPeriod.getExamPeriodStatus().getStatusId() == 1)) {
			throw new EntityExistsException(examPeriod, "At least one ExamPeriod with status: ACTIVE is already present in the database");
		}
		
		if(examPeriodRepository.existsById(examPeriod.getId())) {
			return examPeriodRepository.save(examPeriod);
		}
		throw new InvalidEntityException(examPeriod, "This examPeriod doesn't exist!");
	}

	@Override
	public Page<ExamPeriod> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Sort.Direction direction = "asc".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC;
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(direction, sortBy));

		Page<ExamPeriod> entites = examPeriodRepository.findAll(pageable);
		return entites;
	}

	@Override
	public ExamPeriod findActiveExamPeriods() {
		return this.examPeriodRepository.findActiveExamPeriods();
	}
}
