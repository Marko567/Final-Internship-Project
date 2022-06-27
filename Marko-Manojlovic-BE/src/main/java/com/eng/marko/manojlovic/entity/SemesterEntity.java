package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SemesterEntity implements Serializable {
	private static final long serialVersionUID = 3645852034473462391L;
	
	@Id
	private Integer semesterEntityId;
	@Column
	private String semesterName;

	public SemesterEntity() {
	}

	public SemesterEntity(Integer semesterEntityId, String semesterName) {
		super();
		this.semesterEntityId = semesterEntityId;
		this.semesterName = semesterName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(semesterEntityId, semesterName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemesterEntity other = (SemesterEntity) obj;
		return Objects.equals(semesterEntityId, other.semesterEntityId)
				&& Objects.equals(semesterName, other.semesterName);
	}

	@Override
	public String toString() {
		return "SemesterEntity [semesterEntityId=" + semesterEntityId + ", semesterName=" + semesterName + "]";
	}

}
