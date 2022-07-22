package com.eng.marko.manojlovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.dto.SemesterDto;
import com.eng.marko.manojlovic.service.SemesterService;

@RestController
@RequestMapping("semesters")
public class SemesterRestController {
	@Autowired
	private SemesterService semesterService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<SemesterDto>> findAll() {
		return ResponseEntity.ok(semesterService.findAll());
	}
}
