package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class ExamPeriod implements Serializable {
	private static final long serialVersionUID = 6340006463850422524L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date startDate;
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date endDate;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "status")
	private ExamPeriodStatus examPeriodStatus;

	public ExamPeriod() {
	}

	public ExamPeriod(Long id, String name, Date startDate, Date endDate, ExamPeriodStatus examPeriodStatus) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.examPeriodStatus = examPeriodStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ExamPeriodStatus getExamPeriodStatus() {
		return examPeriodStatus;
	}

	public void setExamPeriodStatus(ExamPeriodStatus examPeriodStatus) {
		this.examPeriodStatus = examPeriodStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDate, examPeriodStatus, id, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamPeriod other = (ExamPeriod) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(examPeriodStatus, other.examPeriodStatus)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "ExamPeriod [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", examPeriodStatus=" + examPeriodStatus + "]";
	}

}
