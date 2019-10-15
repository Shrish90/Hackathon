package com.hackathon.model;

/**
* <h1>Corporate Details Modal </h1>
* This is the Modal Class for Corporate Details
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/
public class CorporateDetails {

	private String name;
	
	private String corporateAddress;
	private Double revenue;
	private String regNo;
	private int companyAge;
	
	
	public int getCompanyAge() {
		return companyAge;
	}
	public void setCompanyAge(int companyAge) {
		this.companyAge = companyAge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCorporateAddress() {
		return corporateAddress;
	}
	public void setCorporateAddress(String corporateAddress) {
		this.corporateAddress = corporateAddress;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
}
