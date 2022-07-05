package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Professor implements Serializable {
	private static final long serialVersionUID = 4101600559582984194L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long professorId;
	
	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String lastname;
	@Column(unique=true)
	private String email;
	@Column
	private String address;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "postal_code")
	private City postalCode;
	
	@Column
	private String phone;
	@Column(nullable=false)
	private Date reelectionDate;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "title", nullable=false)
	private Title title;
	
	@OneToMany(mappedBy="professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Engagement> engagements = new HashSet<>();
	
	public Professor() {
	}
	
	public Professor(String firstname, String lastname, String email, String address, City postalCode, String phone,
			Date reelectionDate, Title title, Set<Engagement> engagements) {
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

	public Professor(Long professorId, String firstname, String lastname, String email, String address, City postalCode,
			String phone, Date reelectionDate, Title title, Set<Engagement> engagements) {
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
		Professor other = (Professor) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(phone, other.phone) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(professorId, other.professorId)
				&& Objects.equals(reelectionDate, other.reelectionDate) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", address=" + address + ", postalCode=" + postalCode + ", phone=" + phone
				+ ", reelectionDate=" + reelectionDate + ", title=" + title + ", engagements=" + engagements + "]";
	}

}
