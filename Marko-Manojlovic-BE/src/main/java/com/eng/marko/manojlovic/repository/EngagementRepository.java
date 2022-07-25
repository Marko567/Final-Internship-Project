package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.entity.EngagementIdUsingIdClass;

public interface EngagementRepository extends JpaRepository<Engagement, EngagementIdUsingIdClass>{
	
}
