package com.eng.marko.manojlovic.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table
public class Exam {
	@EmbeddedId
	private ExamId id;
	
	@ManyToOne
	@MapsId("examPeriodId")
	@JoinColumn(name="exam_period_id")
	private ExamPeriod examPeriod;
	
	@ManyToOne
	@MapsId("subjectId")
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	
	@ManyToOne
	@MapsId("professorId")
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@Column
	private Date date;

	public Exam(ExamId id, ExamPeriod examPeriod, Subject subject, Professor professor, Date date) {
		super();
		this.id = new ExamId(examPeriod.getId(), subject.getSubjectId(), professor.getProfessorId());
		this.examPeriod = examPeriod;
		this.subject = subject;
		this.professor = professor;
		this.date = date;
	}
	
}
