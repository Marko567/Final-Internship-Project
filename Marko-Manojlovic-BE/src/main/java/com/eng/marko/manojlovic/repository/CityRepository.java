package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.marko.manojlovic.entity.City;

public interface CityRepository extends JpaRepository<City, Long>  {
	
}
