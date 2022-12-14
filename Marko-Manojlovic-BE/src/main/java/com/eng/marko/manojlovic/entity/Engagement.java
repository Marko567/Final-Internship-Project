package com.eng.marko.manojlovic.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(EngagementIdUsingIdClass.class)
public class Engagement {
	@Id
	private Long professorId;

	@Id
	private Long subjectId;

	public Engagement() {
		super();
	}

	public Engagement(Long professorId, Long subjectId) {
		super();
		this.professorId = professorId;
		this.subjectId = subjectId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(professorId, subjectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engagement other = (Engagement) obj;
		return Objects.equals(professorId, other.professorId) && Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "Engagement [professorId=" + professorId + ", subjectId=" + subjectId + "]";
	}
}
