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

	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Integer noOfEsp;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "semester")
	private SemesterEntity semester;
	
	@OneToMany(mappedBy="subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Engagement> engagements = new HashSet<>();
	
	public Subject() {
		super();
	}

	public Subject(String name, String description, Integer noOfEsp, SemesterEntity semester) {
		super();
		this.name = name;
		this.description = description;
		this.noOfEsp = noOfEsp;
		this.semester = semester;
	}

	public Subject(Long subjectId, String name, String description, Integer noOfEsp, SemesterEntity semester) {
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
	
	public Set<Engagement> getEngagements() {
		return engagements;
	}

	public void setEngagements(Set<Engagement> engagements) {
		this.engagements = engagements;
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
		Subject other = (Subject) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(noOfEsp, other.noOfEsp) && semester == other.semester
				&& Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", noOfEsp="
				+ noOfEsp + ", semester=" + semester + "]";
	}

}
