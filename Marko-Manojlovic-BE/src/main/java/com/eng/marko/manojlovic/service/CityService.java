package com.eng.marko.manojlovic.service;

import java.util.List;
import java.util.Optional;

import com.eng.marko.manojlovic.entity.City;

public interface CityService {
	List<City> findAll();
	Optional<City> findById(Long zipCode);
}
