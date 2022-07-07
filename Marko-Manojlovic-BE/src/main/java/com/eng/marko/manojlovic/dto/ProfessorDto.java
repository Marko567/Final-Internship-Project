package com.eng.marko.manojlovic.dto;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eng.marko.manojlovic.entity.City;
import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.entity.Title;

public class ProfessorDto {
	private Long professorId;
	
	@NotEmpty(message="Firstname is required!")
	@Size(min=3, message="Minimal number of characters is three")
	private String firstname;
	
	@NotEmpty(message="Lastname is required!")
	@Size(min=3, message="Minimal number of characters is three")
	private String lastname;
	
	@Email(regexp="^(.+)@(.+)$", message="Email must contain '@' character")
	private String email;
	
	@Size(min=3, message="Minimal number of characters is three")
	private String address;

	private City postalCode;
	
	@Size(min=9, message="Minimal number of characters is 9")
	private String phone;
	
	@NotNull(message="Reelection Date is required")
	private Date reelectionDate;
	
	@NotNull(message="Title is required")
	private Title title;
	
	private Set<Engagement> engagements;

	public ProfessorDto() {
	}

	public ProfessorDto(Long professorId, String firstname, String lastname, String email, String address,
			City postalCode, String phone, Date reelectionDate, Title title, Set<Engagement> engagements) {
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
		this.engagements = engagements;
	}
	
	public ProfessorDto(String firstname, String lastname, String email, String address, City postalCode, String phone,
			Date reelectionDate, Title title, Set<Engagement> engagements ) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.title = title;
		this.engagements = engagements;
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

	public Set<Engagement> getEngagements() {
		return engagements;
	}

	public void setEngagements(Set<Engagement> engagements) {
		this.engagements = engagements;
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
				+ ", reelectionDate=" + reelectionDate + ", title=" + title + ", engagements=" + engagements + "]";
	}

}
