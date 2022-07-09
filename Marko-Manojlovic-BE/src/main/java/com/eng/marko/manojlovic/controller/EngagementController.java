package com.eng.marko.manojlovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.repository.EngagementRepository;

@RestController
@RequestMapping("engagements")
public class EngagementController {
	@Autowired
	private EngagementRepository engagementRepository;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<Engagement>> findAll() {
		return ResponseEntity.ok(engagementRepository.findAll());
	}
}
