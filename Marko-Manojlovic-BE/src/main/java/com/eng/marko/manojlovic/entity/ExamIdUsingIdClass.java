package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

public class ExamIdUsingIdClass implements Serializable {
	private static final long serialVersionUID = -2587324053525255065L;

	private Long examPeriodId;
	private Long professorId;
	private Long subjectId;

	public ExamIdUsingIdClass() {
	}

	public ExamIdUsingIdClass(Long examPeriodId, Long professorId, Long subjectId) {
		super();
		this.examPeriodId = examPeriodId;
		this.professorId = professorId;
		this.subjectId = subjectId;
	}

	public Long getExamPeriodId() {
		return examPeriodId;
	}

	public void setExamPeriodId(Long examPeriodId) {
		this.examPeriodId = examPeriodId;
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
		return Objects.hash(examPeriodId, professorId, subjectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamIdUsingIdClass other = (ExamIdUsingIdClass) obj;
		return Objects.equals(examPeriodId, other.examPeriodId) && Objects.equals(professorId, other.professorId)
				&& Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "ExamIdUsingIdClass [examPeriodId=" + examPeriodId + ", professorId=" + professorId + ", subjectId="
				+ subjectId + "]";
	}

}
