package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

public class EngagementIdUsingIdClass implements Serializable {
	private static final long serialVersionUID = -663454679720269415L;

	private Long subjectId;
	private Long professorId;

	public EngagementIdUsingIdClass() {
	}

	public EngagementIdUsingIdClass(Long subjectId, Long professorId) {
		super();
		this.subjectId = subjectId;
		this.professorId = professorId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
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
		EngagementIdUsingIdClass other = (EngagementIdUsingIdClass) obj;
		return Objects.equals(professorId, other.professorId) && Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "EngagementIdUsingIdClass [subjectId=" + subjectId + ", professorId=" + professorId + "]";
	}

}
