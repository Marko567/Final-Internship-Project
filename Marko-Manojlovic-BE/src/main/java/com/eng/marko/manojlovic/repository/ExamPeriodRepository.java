package com.eng.marko.manojlovic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eng.marko.manojlovic.entity.ExamPeriod;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
	
	@Query("SELECT e FROM ExamPeriod e WHERE e.examPeriodStatus = 1")
    ExamPeriod findActiveExamPeriods();
}
