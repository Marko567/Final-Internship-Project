package com.eng.marko.manojlovic.dto;

import java.sql.Date;
import java.util.Objects;


import com.eng.marko.manojlovic.entity.City;
import com.eng.marko.manojlovic.entity.Title;

public class ProfessorDto {
	private Long professorId;

	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private City postalCode;

	private String phone;
	private Date reelectionDate;

	private Title title;

	public ProfessorDto() {
	}

	public ProfessorDto(Long professorId, String firstname, String lastname, String email, String address,
			City postalCode, String phone, Date reelectionDate, Title title) {
		super();
		this.professorId = professorId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.title = title;
	}
	
	public ProfessorDto(String firstname, String lastname, String email, String address, City postalCode, String phone,
			Date reelectionDate, Title title) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.title = title;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(City postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReelectionDate() {
		return reelectionDate;
	}

	public void setReelectionDate(Date reelectionDate) {
		this.reelectionDate = reelectionDate;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstname, lastname, phone, postalCode, professorId, reelectionDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorDto other = (ProfessorDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(phone, other.phone) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(professorId, other.professorId)
				&& Objects.equals(reelectionDate, other.reelectionDate) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "ProfessorDto [professorId=" + professorId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", address=" + address + ", postalCode=" + postalCode + ", phone=" + phone
				+ ", reelectionDate=" + reelectionDate + ", title=" + title + "]";
	}

}
