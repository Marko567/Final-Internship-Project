package com.eng.marko.manojlovic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.ExamPeriod;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.service.ExamPeriodService;

@RestController
@RequestMapping("exam-periods")
public class ExamPeriodRestController {
	@Autowired
	private ExamPeriodService examPeriodService;
	
	@GetMapping(path="all")
	public @ResponseBody ResponseEntity<List<ExamPeriod>> findAll() {
		return ResponseEntity.ok(examPeriodService.findAll());
	}
	
	@GetMapping("filter")
	public ResponseEntity<Page<ExamPeriod>> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder) {
		return new ResponseEntity<Page<ExamPeriod>>(examPeriodService.findAll(pageNo, pageSize, sortBy, sortOrder), new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@GetMapping(path="{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<ExamPeriod> examPeriod = examPeriodService.findById(id);
		
		if(examPeriod.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(examPeriod.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID!");
		}
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Object> saveExamPeriod(@RequestBody ExamPeriod examPeriod) {
		try {
			ExamPeriod ePeriod = examPeriodService.saveExamPeriod(examPeriod);
			return ResponseEntity.status(HttpStatus.OK).body(ePeriod);
		} catch(EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<Object> editExamPeriod(@RequestBody ExamPeriod examPeriod) {
		try {
			ExamPeriod ep = examPeriodService.updateExamPeriod(examPeriod);
			return ResponseEntity.status(HttpStatus.OK).body(ep);
		} catch(EntityExistsException e) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<String> deleteExamPeriod(@PathVariable Long id) {
		try {
			examPeriodService.deleteExamPeriod(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted " + id);
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}
	
	@GetMapping(path="active")
	public @ResponseBody ResponseEntity<Object> findActiveExamPeriods() {
		ExamPeriod examPeriod = examPeriodService.findActiveExamPeriods();
		return ResponseEntity.status(HttpStatus.OK).body(examPeriod);
	}
}
