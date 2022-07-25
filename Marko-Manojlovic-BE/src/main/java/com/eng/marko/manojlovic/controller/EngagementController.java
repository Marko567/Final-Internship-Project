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

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.exception.MyException;
import com.eng.marko.manojlovic.service.EngagementService;

@RestController
@RequestMapping("engagements")
public class EngagementController {
	@Autowired
	private EngagementService engagementService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<Engagement>> findAll() {
		return ResponseEntity.ok(engagementService.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Object> saveEngagements(@RequestBody List<Engagement> engagements) {
		try {
			engagementService.saveEngagements(engagements);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch(MyException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
