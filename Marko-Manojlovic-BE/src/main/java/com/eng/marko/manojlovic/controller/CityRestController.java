package com.eng.marko.manojlovic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.City;
import com.eng.marko.manojlovic.service.CityService;

@RestController
@RequestMapping("cities")
public class CityRestController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<City>> findAll() {
		return ResponseEntity.ok(cityService.findAll());
	}
	
	@GetMapping(path="{zipCode}")
	public ResponseEntity<Object> findById(@PathVariable Long zipCode) {
		Optional<City> city = cityService.findById(zipCode);
		
		if(city.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(city.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid zipCode!");
		}
	}
}