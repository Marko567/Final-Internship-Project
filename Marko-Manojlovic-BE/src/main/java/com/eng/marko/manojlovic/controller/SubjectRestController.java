package com.eng.marko.manojlovic.controller;

import java.util.List;
import java.util.Optional;

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

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.service.SubjectService;

@RestController
@RequestMapping("subjects")
public class SubjectRestController {
	private final SubjectService subjectService;

	public SubjectRestController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}
	
	@GetMapping(path="all")
	public @ResponseBody ResponseEntity<List<SubjectDto>> findAll() {
		List<SubjectDto> subjectDtos = subjectService.findAllSubjects();
		return ResponseEntity.ok(subjectDtos);
	}

	@GetMapping("filter")
	public ResponseEntity<Page<SubjectDto>> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder) {
		return new ResponseEntity<Page<SubjectDto>>(subjectService.findAll(pageNo, pageSize, sortBy, sortOrder), new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@GetMapping(path="{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<SubjectDto> subjectDto = subjectService.findById(id);
		return subjectDto.<ResponseEntity<Object>>map(dto -> ResponseEntity.status(HttpStatus.OK).body(dto))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID!"));
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Object> saveSubject(@RequestBody SubjectDto subjectDto) {
		try {
			SubjectDto subject = subjectService.saveSubject(subjectDto);
			return ResponseEntity.status(HttpStatus.OK).body(subject);
		} catch(EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<String> deleteSubject(@PathVariable Long id) {
		try {
			subjectService.deleteSubject(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted " + id);
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<Object> editSubject(@RequestBody SubjectDto subjectDto) {
		try {
			SubjectDto entity = subjectService.updateSubject(subjectDto);
			return ResponseEntity.status(HttpStatus.OK).body(entity);
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
