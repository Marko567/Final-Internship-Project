package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamId implements Serializable {
	private static final long serialVersionUID = 3551899020738245198L;

	@Column
	private Long examPeriodId;
	@Column
	private Long subjectId;
	@Column
	private Long professorId;
	
	
	public ExamId(Long examPeriodId, Long subjectId, Long professorId) {
		super();
		this.examPeriodId = examPeriodId;
		this.subjectId = subjectId;
		this.professorId = professorId;
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
		ExamId other = (ExamId) obj;
		return Objects.equals(examPeriodId, other.examPeriodId) && Objects.equals(professorId, other.professorId)
				&& Objects.equals(subjectId, other.subjectId);
	}
}
