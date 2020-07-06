package com.demo.bankaccount.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Suma Generates class with parameters
 *         userName,panNumber,occupation,accountType
 *         salary,dateOfBirth,mobileNumber
 *
 */

public class RegisterRequestDto {
	@NotEmpty(message = "first name must not be empty")
	private String userName;
	@NotEmpty(message = "PAN NUMBER must not be empty")
	private String panNumber;
	@NotEmpty(message = "occupation must not be empty")
	private String occupation;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@NotNull(message = "salary must not be empty")
	private double salary;
	@NotEmpty(message = "dateOfBirth must not be empty")
	private String dateOfBirth;
	@NotEmpty(message = "mobileNumber must not be empty")
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
