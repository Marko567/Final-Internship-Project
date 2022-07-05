package com.eng.marko.manojlovic.mapper;



import org.springframework.stereotype.Component;

import com.eng.marko.manojlovic.dto.ProfessorDto;
import com.eng.marko.manojlovic.entity.Professor;

@Component
public class ProfessorMapper {
	
	public Professor toEntity(ProfessorDto dto) {
		return new Professor(dto.getProfessorId(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), dto.getAddress(),
				dto.getPostalCode(), dto.getPhone(), dto.getReelectionDate(), dto.getTitle(), dto.getEngagements());
	}
	
	public ProfessorDto toDto(Professor entity) {
		
		return new ProfessorDto(entity.getProfessorId(), entity.getFirstname(), entity.getLastname(),
				entity.getEmail(), entity.getAddress(),
				entity.getPostalCode(), entity.getPhone(),
				entity.getReelectionDate(), entity.getTitle(), entity.getEngagements());
	}
	
	public Professor toEntityNoId(ProfessorDto dto) {
		
		return new Professor(dto.getFirstname(), dto.getLastname(), dto.getEmail(), dto.getAddress(),
				dto.getPostalCode(), dto.getPhone(), dto.getReelectionDate(), dto.getTitle(), dto.getEngagements());
	}
	
	public ProfessorDto toDtoNoId(Professor entity) {
		
		return new ProfessorDto(entity.getFirstname(), entity.getLastname(),
				entity.getEmail(), entity.getAddress(),
				entity.getPostalCode(), entity.getPhone(),
				entity.getReelectionDate(), entity.getTitle(), entity.getEngagements());
	}
}