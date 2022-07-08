package com.eng.marko.manojlovic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.entity.EngagementId;
import com.eng.marko.manojlovic.entity.Professor;

public interface EngagementRepository extends JpaRepository<Engagement, EngagementId>{
	
	/*@Query("SELECT c.professor FROM Engagement c WHERE c.id = subjectId.id")
	List<Professor> getProfessorsEngagedOnSubject(@Param(value = "subjectId") EngagementId id);*/
}
