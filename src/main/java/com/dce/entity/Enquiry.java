package com.dce.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Enquiry {

	private String firstName;
	private String middleName;
	private String lastName;
	private String qualification;
	private String profession;
	private String address;
	private String mobileNo;
	private String emailId;
	private String course;
	private Double fess;
	@DateTimeFormat(pattern = "YYYY-MM-DD hh.mm")
	private Date dateOfEnquiry;
	private String gender;
	private String tempId;
	private String remarks;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Double getFess() {
		return this.fess;
	}

	public void setFess(Double fess) {
		this.fess = fess;
	}

	public Date getDateOfEnquiry() {
		return this.dateOfEnquiry;
	}

	public void setDateOfEnquiry(Date dateOfEnquiry) {
		this.dateOfEnquiry = dateOfEnquiry;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTempId() {
		return this.tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getFullName() {

		return this.firstName + " " + this.lastName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
