package com.demo.bankaccount.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
/**
* @author haritha
*
*/
public class AccountResponseDto {
	
	
	private String accountNumber;
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
