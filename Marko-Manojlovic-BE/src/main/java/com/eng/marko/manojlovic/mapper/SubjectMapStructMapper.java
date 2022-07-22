package com.eng.marko.manojlovic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import com.eng.marko.manojlovic.dto.SemesterDto;
import com.eng.marko.manojlovic.dto.SubjectDto;
import com.eng.marko.manojlovic.entity.SemesterEntity;
import com.eng.marko.manojlovic.entity.Subject;


@Mapper(componentModel="spring")
public interface SubjectMapStructMapper {
	@Mappings({
		@Mapping(target="subjectId", source="entity.subjectId"),
		@Mapping(target="name", source="entity.name"),
		@Mapping(target="description", source="entity.description"),
		@Mapping(target="noOfEsp", source="entity.noOfEsp"),
		@Mapping(target="yearOfStudy", source="entity.yearOfStudy"),
	})
	SubjectDto toDto(Subject entity);
	
	@Mappings({
		@Mapping(target="subjectId", source="dto.subjectId"),
		@Mapping(target="name", source="dto.name"),
		@Mapping(target="description", source="dto.description"),
		@Mapping(target="noOfEsp", source="dto.noOfEsp"),
		@Mapping(target="yearOfStudy", source="dto.yearOfStudy"),
	})
	Subject toEntity(SubjectDto dto);
	
	@Mappings({
		@Mapping(target="name", source="dto.name"),
		@Mapping(target="description", source="dto.description"),
		@Mapping(target="noOfEsp", source="dto.noOfEsp"),
		@Mapping(target="yearOfStudy", source="dto.yearOfStudy"),
	})
	Subject toEntityNoId(SubjectDto dto);
	
	@Mappings({
		@Mapping(target="id", source="semesterEntityId"),
		@Mapping(target="name", source="semesterName")
	})
	SemesterDto toDto(SemesterEntity entity);
	
	
	@Mappings({
		@Mapping(target="semesterEntityId", source="id"),
		@Mapping(target="semesterName", source="name")
	})
	SemesterEntity toEntity(SemesterDto dto);
}
