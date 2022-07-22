package com.eng.marko.manojlovic.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SubjectDto {
	private Long subjectId;

	@NotEmpty(message = "Name is required!")
	@Size(min = 3, message = "Minimum number of characters is three")
	private String name;

	private String description;

	@NotNull(message = "No of esp is required!")
	private Integer noOfEsp;

	@NotNull(message = "Year of Study is required!")
	private Integer yearOfStudy;

	@NotNull(message = "Semester is required!")
	private SemesterDto semester;

	public SubjectDto() {
		super();
	}

	public SubjectDto(Long subjectId, String name, String description, Integer noOfEsp, Integer yearOfStudy,
			SemesterDto semester) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}

	public SubjectDto(String name, String description, Integer noOfEsp, Integer yearOfStudy, SemesterDto semester) {
		super();
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}

	public Integer getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
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

	public SemesterDto getSemester() {
		return semester;
	}

	public void setSemester(SemesterDto semester) {
		this.semester = semester;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, noOfEsp, semester, subjectId, yearOfStudy);
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
				&& Objects.equals(subjectId, other.subjectId) && Objects.equals(yearOfStudy, other.yearOfStudy);
	}

	@Override
	public String toString() {
		return "SubjectDto [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", noOfEsp="
				+ noOfEsp + ", yearOfStudy=" + yearOfStudy + ", semester=" + semester + "]";
	}

}
