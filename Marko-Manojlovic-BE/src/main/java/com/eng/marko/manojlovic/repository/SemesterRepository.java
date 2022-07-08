package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eng.marko.manojlovic.entity.SemesterEntity;

@Repository
public interface SemesterRepository extends JpaRepository<SemesterEntity, Long> {
	
}
