package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.marko.manojlovic.entity.SemesterEntity;

public interface SemesterRepository extends JpaRepository<SemesterEntity, Long> {
	
}
