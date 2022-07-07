package com.eng.marko.manojlovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.ExamPeriodStatus;
import com.eng.marko.manojlovic.service.ExamPeriodStatusService;

@RestController
@RequestMapping("exam-period-statuses")
public class ExamPeriodStatusRestController {
	@Autowired
	private ExamPeriodStatusService examPeriodStatusService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<ExamPeriodStatus>> findAll() {
		return ResponseEntity.ok(examPeriodStatusService.findAll());
	}
}