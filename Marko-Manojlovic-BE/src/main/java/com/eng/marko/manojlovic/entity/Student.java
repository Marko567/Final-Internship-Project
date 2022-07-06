package com.eng.marko.manojlovic.entity;

import java.io.Serializable;
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

@Entity
@Table
public class Student implements Serializable {
	private static final long serialVersionUID = 6906887303502423143L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Long studentId;
	
	@Column(length=4, unique=true, nullable=false)
	private String indexNumber;
	
	@Column(length=4, nullable=false)
	private Integer indexYear;
	
	@Column(length=30, nullable=false)
	private String firstname;
	
	@Column(length=30, nullable=false)
	private String lastname;
	
	@Column(length=30, unique=true)
	private String email;
	
	@Column(length=50)
	private String address;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "postal_code")
	private City postalCode;
	
	@Column(length=7, nullable=false)
	private Integer currentYearOfStudy;

	public Student() {
	}
	
	public Student(String indexNumber, Integer indexYear, String firstname, String lastname, String email,
			String address, City postalCode, Integer currentYearOfStudy) {
		super();
		this.indexNumber = indexNumber;
		this.indexYear = indexYear;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.currentYearOfStudy = currentYearOfStudy;
	}


	public Student(Long studentId, String indexNumber, Integer indexYear, String firstname, String lastname,
			String email, String address, City postalCode, Integer currentYearOfStudy) {
		super();
		this.studentId = studentId;
		this.indexNumber = indexNumber;
		this.indexYear = indexYear;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.currentYearOfStudy = currentYearOfStudy;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public Integer getIndexYear() {
		return indexYear;
	}

	public void setIndexYear(Integer indexYear) {
		this.indexYear = indexYear;
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

	public Integer getCurrentYearOfStudy() {
		return currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(Integer currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, currentYearOfStudy, email, firstname, indexNumber, indexYear, lastname, postalCode,
				studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(currentYearOfStudy, other.currentYearOfStudy)
				&& Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(indexNumber, other.indexNumber) && Objects.equals(indexYear, other.indexYear)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(studentId, other.studentId);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", indexNumber=" + indexNumber + ", indexYear=" + indexYear
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", address=" + address
				+ ", postalCode=" + postalCode + ", currentYearOfStudy=" + currentYearOfStudy + "]";
	}

}
