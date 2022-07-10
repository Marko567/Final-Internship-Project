package com.eng.marko.manojlovic.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(ExamIdUsingIdClass.class)
public class Exam {

	@Id
	private Long examPeriodId;

	@Id
	private Long professorId;

	@Id
	private Long subjectId;

	@Column
	private Date date;

	public Exam() {
		super();
	}

	public Exam(Long examPeriodId, Long professorId, Long subjectId, Date date) {
		super();
		this.examPeriodId = examPeriodId;
		this.professorId = professorId;
		this.subjectId = subjectId;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, examPeriodId, professorId, subjectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		return Objects.equals(date, other.date) && Objects.equals(examPeriodId, other.examPeriodId)
				&& Objects.equals(professorId, other.professorId) && Objects.equals(subjectId, other.subjectId);
	}

	@Override
	public String toString() {
		return "Exam [examPeriodId=" + examPeriodId + ", professorId=" + professorId + ", subjectId=" + subjectId
				+ ", date=" + date + "]";
	}

}
