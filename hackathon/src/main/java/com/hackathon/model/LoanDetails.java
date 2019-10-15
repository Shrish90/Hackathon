package com.hackathon.model;

/**
* <h1>Loan Details Modal </h1>
* This is the Modal Class for Loan Details
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/
public class LoanDetails {
	
	private Double amount;
	private int term;
	private String usage;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	
}
