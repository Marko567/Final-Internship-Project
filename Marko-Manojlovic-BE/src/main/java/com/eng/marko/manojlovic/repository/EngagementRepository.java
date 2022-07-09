package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.entity.EngagementId;

public interface EngagementRepository extends JpaRepository<Engagement, EngagementId>{
	
	/*@Query("SELECT c.professor FROM Engagement c WHERE c.id = subjectId.id")
	List<Professor> getProfessorsEngagedOnSubject(@Param(value = "subjectId") EngagementId id);*/
}
