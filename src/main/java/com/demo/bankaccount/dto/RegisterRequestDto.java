package com.demo.bankaccount.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Suma
 * Generates class with parameters userName,panNumber,occupation,accountType
 * salary,dateOfBirth,mobileNumber
 *
 */
public class RegisterRequestDto {
	
	private String userName;
	private String panNumber;
	private String occupation;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private double salary;
	private String dateOfBirth;
	private String mobileNumber;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	

}
