package com.eng.marko.manojlovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.entity.Title;
import com.eng.marko.manojlovic.service.TitleService;

@RestController
@RequestMapping("titles")
public class TitleRestController {
	@Autowired
	private TitleService titleService;
	
	@GetMapping("all")
	public @ResponseBody ResponseEntity<List<Title>> findAll() {
		return ResponseEntity.ok(titleService.findAll());
	}
}
