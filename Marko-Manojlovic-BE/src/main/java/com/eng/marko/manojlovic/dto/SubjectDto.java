package com.eng.marko.manojlovic.dto;

import java.util.Objects;

import com.eng.marko.manojlovic.entity.SemesterEntity;

public class SubjectDto {
	private Long subjectId;

	private String name;

	private String description;

	private Integer noOfEsp;

	private SemesterEntity semester;

	public SubjectDto() {
		super();
	}

	public SubjectDto(Long subjectId, String name, String description, Integer noOfEsp, SemesterEntity semester) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.semester = semester;
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

	public SemesterEntity getSemester() {
		return semester;
	}

	public void setSemester(SemesterEntity semester) {
		this.semester = semester;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, noOfEsp, semester, subjectId);
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
				&& Objects.equals(noOfEsp, other.noOfEsp) && Objects.equals(semester, other.semester)
				&& Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "SubjectDto [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", noOfEsp="
				+ noOfEsp + ", semester=" + semester + "]";
	}

}
