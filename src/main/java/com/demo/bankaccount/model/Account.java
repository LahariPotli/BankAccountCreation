package com.demo.bankaccount.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.demo.bankaccount.dto.AccountType;
/**
 * Generates Account table with accountId,accountNumber,balance,
 * accountType and userId
 * @author haritha
 *
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long accountId;
	private String accountNumber;
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
