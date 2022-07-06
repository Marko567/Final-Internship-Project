package com.eng.marko.manojlovic.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.eng.marko.manojlovic.entity.SemesterEntity;

public class SubjectDto {
	private Long subjectId;
	
	@Size(min=3, message="Minimal number of characters is three")
	private String name;

	private String description;

	private Integer noOfEsp;

	//private SemesterEntity semester;
	private Integer semesterEntityId;
	@NotNull(message="Semester name is required!")
	private String semesterName;

	public SubjectDto() {
		super();
	}
	
	public SubjectDto(String name, String description, Integer noOfEsp, Integer semesterEntityId, String semesterName) {
		super();
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.semesterEntityId = semesterEntityId;
		this.semesterName = semesterName;
	}


	public SubjectDto(Long subjectId, String name, String description, Integer noOfEsp, Integer semesterEntityId,
			String semesterName) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.semesterEntityId = semesterEntityId;
		this.semesterName = semesterName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNoOfEsp() {
		return noOfEsp;
	}

	public void setNoOfEsp(Integer noOfEsp) {
		this.noOfEsp = noOfEsp;
	}

	public Integer getSemesterEntityId() {
		return semesterEntityId;
	}

	public void setSemesterEntityId(Integer semesterEntityId) {
		this.semesterEntityId = semesterEntityId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, noOfEsp, semesterEntityId, semesterName, subjectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectDto other = (SubjectDto) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(noOfEsp, other.noOfEsp) && Objects.equals(semesterEntityId, other.semesterEntityId)
				&& Objects.equals(semesterName, other.semesterName) && Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "SubjectDto [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", noOfEsp="
				+ noOfEsp + ", semesterEntityId=" + semesterEntityId + ", semesterName=" + semesterName + "]";
	}
}
