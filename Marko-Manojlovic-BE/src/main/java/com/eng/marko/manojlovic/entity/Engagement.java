package com.eng.marko.manojlovic.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table
public class Engagement {
	@EmbeddedId
	private EngagementId id;
	
	@ManyToOne
	@MapsId("professorId")
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToOne
	@MapsId("subjectId")
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	
	public Engagement() {
		super();
	}

	public Engagement(Professor professor, Subject subject) {
		this.id = new EngagementId(professor.getProfessorId(), subject.getSubjectId());
		this.professor = professor;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Engagement [id=" + id + ", professor=" + professor.getFirstname() + ", subject=" + subject.getName() + "]";
	}
}
