package com.demo.bankaccount.dto;

/**
 * @author Suma
 * Generates class with parameters customerId and password
 *
 */
public class LoginDto {
	
	
	private String customerId;
	private String password;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
