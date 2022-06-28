package com.eng.marko.manojlovic.mapper;

import org.springframework.stereotype.Component;

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.entity.Subject;

@Component
public class SubjectMapper {
	
	public Subject toEntity(SubjectDto dto) {
		return new Subject(dto.getSubjectId(), dto.getName(), dto.getDescription(), dto.getNoOfEsp(), dto.getSemester());
	}
	
	public SubjectDto toDto(Subject entity) {
		return new SubjectDto(entity.getSubjectId(), entity.getName(), entity.getDescription(), entity.getNoOfEsp(), entity.getSemester());
	}
}
