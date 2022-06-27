package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ExamPeriodStatus implements Serializable {
	private static final long serialVersionUID = -3397678266482174779L;
	
	@Id
	private Integer statusId;
	@Column
	private String name;
	
	public ExamPeriodStatus() {}

	public ExamPeriodStatus(Integer statusId, String name) {
		super();
		this.statusId = statusId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, statusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamPeriodStatus other = (ExamPeriodStatus) obj;
		return Objects.equals(name, other.name) && Objects.equals(statusId, other.statusId);
	}
	
}
