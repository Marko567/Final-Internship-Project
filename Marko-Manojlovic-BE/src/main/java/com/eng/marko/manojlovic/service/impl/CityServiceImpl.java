package com.eng.marko.manojlovic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.City;
import com.eng.marko.manojlovic.repository.CityRepository;
import com.eng.marko.manojlovic.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;
	
	
	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}


	@Override
	public Optional<City> findById(Long zipCode) {
		Optional<City> existingCity = cityRepository.findById(zipCode);
		if(existingCity.isPresent()) {
			return existingCity;
		}
		return Optional.empty();
	}
}
