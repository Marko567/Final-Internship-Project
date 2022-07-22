package com.eng.marko.manojlovic.mapper;

import org.springframework.stereotype.Component;

import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.entity.SemesterEntity;
import com.eng.marko.manojlovic.entity.Subject;

@Component
public class SubjectMapper {
	
	public Subject toEntity(SubjectDto dto) {
		return new Subject(dto.getSubjectId(), dto.getName(), dto.getDescription(),
				dto.getNoOfEsp(), dto.getYearOfStudy(), new SemesterEntity(dto.getSemesterEntityId(), dto.getSemesterName()));
	}
	
	public SubjectDto toDto(Subject entity) {
		return new SubjectDto(entity.getSubjectId(), entity.getName(), entity.getDescription(),
				entity.getNoOfEsp(), entity.getYearOfStudy(), entity.getSemester().getSemesterEntityId(),
				entity.getSemester().getSemesterName());
	}
	
	public Subject toEntityNoId(SubjectDto dto) {
		return new Subject(dto.getName(), dto.getDescription(), dto.getNoOfEsp(), dto.getYearOfStudy(), new SemesterEntity(dto.getSemesterEntityId(), dto.getSemesterName()));
	}
	
	public SubjectDto toDtoNoId(Subject entity) {
		return new SubjectDto(entity.getName(), entity.getDescription(), entity.getNoOfEsp(), entity.getYearOfStudy(), entity.getSemester().getSemesterEntityId(),
				entity.getSemester().getSemesterName());
	}
}
