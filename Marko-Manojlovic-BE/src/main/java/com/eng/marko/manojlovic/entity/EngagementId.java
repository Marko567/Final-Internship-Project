package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
public class EngagementId implements Serializable {
	private static final long serialVersionUID = 6613195630917664168L;

	@Basic
	private Long professorId;
	
	@Basic
	private Long subjectId;
	
	
	public EngagementId() {
		super();
	}
	
	public EngagementId(Long professorId, Long subjectId) {
		super();
		this.professorId = professorId;
		this.subjectId = subjectId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(subjectId, professorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngagementId other = (EngagementId) obj;
		return Objects.equals(subjectId, other.subjectId) && Objects.equals(professorId, other.professorId);
	}
	
}
