package com.hackathon.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* <h1>User Details Modal </h1>
* This is the Modal Class for User Details
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/
public class User {

	private String firstName;
	private String lastName;
	private String address;
	private String citizenship;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dateOfBirth;
	private String phoneNumber;
	private String emailId;
	private String passport;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	
}
