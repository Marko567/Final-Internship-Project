package com.eng.marko.manojlovic.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.eng.marko.manojlovic.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	@Query(
			value = "SELECT p.professor_id, firstname, lastname, email, address, phone, reelection_date, postal_code, title FROM\r\n"
					+ "  Professor p JOIN Engagement e ON p.professor_id = e.professor_id\r\n"
					+ " WHERE subject_id = ?1", 
			  nativeQuery = true)
	List<Professor> getProfessorsEngagedOnSubject(Long id);
}
