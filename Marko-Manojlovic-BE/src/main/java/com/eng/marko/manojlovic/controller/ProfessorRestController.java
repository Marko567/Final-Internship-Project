package com.eng.marko.manojlovic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.dto.ProfessorDto;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.InvalidEntityException;
import com.eng.marko.manojlovic.service.ProfessorService;

@RestController
@RequestMapping("professors")
public class ProfessorRestController {
	private final ProfessorService professorService;

	public ProfessorRestController(ProfessorService professorService) {
		super();
		this.professorService = professorService;
	}
	
	@GetMapping(path="all")
	public @ResponseBody ResponseEntity<List<ProfessorDto>> findAll() { 
		return ResponseEntity.ok(professorService.findAllProfessors());
	}
	
	@GetMapping("filter")
	public ResponseEntity<Page<ProfessorDto>> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "firstname") String sortBy,
			@RequestParam(defaultValue = "asc") String sortOrder) {
		return new ResponseEntity<Page<ProfessorDto>>(professorService.findAll(pageNo, pageSize, sortBy, sortOrder), new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@GetMapping(path="{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<ProfessorDto> professorDto = professorService.findById(id);
		
		return professorDto.<ResponseEntity<Object>>map(dto -> ResponseEntity.status(HttpStatus.OK).body(dto))
				.orElseGet( () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID!"));
	}
	
	@GetMapping("engagedOn/{id}")
	public @ResponseBody ResponseEntity<Object> getProfessorsEngagedOnSubject(@PathVariable Long id) {
		return ResponseEntity.ok(professorService.getProfessorsEngagedOnSubject(id));
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<Object> saveProfessor(@Valid @RequestBody ProfessorDto professorDto) {
		try {
			System.out.println(professorDto);
			ProfessorDto professor = professorService.saveProfessor(professorDto);
			return ResponseEntity.status(HttpStatus.OK).body(professor);
		} catch(EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public @ResponseBody ResponseEntity<String> deleteProfessor(@PathVariable Long id) {
		try {
			professorService.deleteProfessor(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted " + id);
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<Object> editProfessor(@Valid @RequestBody ProfessorDto professorDto) {
		try {
			ProfessorDto entity = professorService.updateProfessor(professorDto);
			return ResponseEntity.status(HttpStatus.OK).body(entity);
		} catch(InvalidEntityException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
        return getStringStringMap(ex);
    }

    static Map<String, String> getStringStringMap(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
