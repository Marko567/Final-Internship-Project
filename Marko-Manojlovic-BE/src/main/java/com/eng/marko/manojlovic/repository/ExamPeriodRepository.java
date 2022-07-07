package com.eng.marko.manojlovic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eng.marko.manojlovic.entity.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
	
	@Query("SELECT e FROM ExamPeriod e WHERE e.id = 1")
    List<ExamPeriod> findActiveExamPeriods();
}
