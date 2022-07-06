package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City implements Serializable {
	private static final long serialVersionUID = 4173469229778929118L;
	@Id
	@Column(length=5)
	private Long zipCode;
	@Column
	private String name;

	public City() {
	}

	public City(Long zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(name, other.name) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "City [zipCode=" + zipCode + ", name=" + name + "]";
	}

}
