package com.eng.marko.manojlovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.Exam;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.service.ExamService;

@RestController
@RequestMapping("exams")
public class ExamRestController {
	@Autowired
	private ExamService examService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<Exam>> findAll() {
		return ResponseEntity.ok(examService.findAllExams());
	}
	
	@GetMapping("/activeExamPeriod")
	public @ResponseBody ResponseEntity<List<Exam>> getExamsFromActiveExamPeriod() {
		return ResponseEntity.ok(examService.getExamsFromActiveExamPeriod());
	}
	
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Object> saveExam(@RequestBody Exam exam) {
		try {
			Exam e = examService.saveExam(exam);
			return ResponseEntity.status(HttpStatus.OK).body(e);
		} catch(EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
