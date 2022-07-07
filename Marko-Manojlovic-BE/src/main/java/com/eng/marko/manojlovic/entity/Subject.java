package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Subject implements Serializable {

	private static final long serialVersionUID = 316218500660471269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long subjectId;

	@Column(length=30, nullable=false)
	private String name;
	@Column(length=200)
	private String description;
	@Column(length=1, nullable=false)
	private Integer noOfEsp;
	
	@Column(length=1, nullable=false)
	private Integer yearOfStudy;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "semester", nullable=false)
	private SemesterEntity semester;
	
	@OneToMany(mappedBy="subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Engagement> engagements = new HashSet<>();
	
	public Subject() {
		super();
	}

	public Subject(String name, String description, Integer noOfEsp, Integer yearOfStudy, SemesterEntity semester) {
		super();
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}

	public Subject(Long subjectId, String name, String description, Integer noOfEsp, Integer yearOfStudy, SemesterEntity semester) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.yearOfStudy = yearOfStudy;
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
	
	public Set<Engagement> getEngagements() {
		return engagements;
	}

	public void setEngagements(Set<Engagement> engagements) {
		this.engagements = engagements;
	}
	
	public Integer getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, engagements, name, noOfEsp, semester, subjectId, yearOfStudy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(description, other.description) && Objects.equals(engagements, other.engagements)
				&& Objects.equals(name, other.name) && Objects.equals(noOfEsp, other.noOfEsp)
				&& Objects.equals(semester, other.semester) && Objects.equals(subjectId, other.subjectId)
				&& Objects.equals(yearOfStudy, other.yearOfStudy);
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", noOfEsp="
				+ noOfEsp + ", yearOfStudy=" + yearOfStudy + ", semester=" + semester + ", engagements=" + engagements
				+ "]";
	}
}
