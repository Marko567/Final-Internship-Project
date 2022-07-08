package com.eng.marko.manojlovic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eng.marko.manojlovic.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	/*@Query("SELECT p FROM Engagement p WHERE p.id = :subjectId")
	List<Professor> getProfessorsEngagedOnSubject(@Param(value = "subjectId") EngagementId id);*/
}
