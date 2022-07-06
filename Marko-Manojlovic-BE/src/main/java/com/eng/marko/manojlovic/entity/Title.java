package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Title implements Serializable {
	private static final long serialVersionUID = 6509651417483048541L;
	@Id
    @Column(length=7)
	private Long titleId;
	@Column
	private String name;

	public Title() {
	}

	public Title(Long titleId, String name) {
		super();
		this.titleId = titleId;
		this.name = name;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, titleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		return Objects.equals(name, other.name) && Objects.equals(titleId, other.titleId);
	}

	@Override
	public String toString() {
		return "Title [titleId=" + titleId + ", name=" + name + "]";
	}

}
