package com.eng.marko.manojlovic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eng.marko.manojlovic.entity.Exam;
import com.eng.marko.manojlovic.entity.ExamId;

public interface ExamRepository extends JpaRepository<Exam, ExamId>{
	
	@Query(value="SELECT e.exam_period_id, e.professor_id, e.subject_id, e.date FROM Exam e JOIN exam_period ep ON e.exam_period_id = ep.id\r\n"
			+ "WHERE ep.status = 1",
			nativeQuery = true)
	List<Exam> getExamsFromActiveExamPeriod();
}
