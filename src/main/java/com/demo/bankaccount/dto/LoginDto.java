package com.demo.bankaccount.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author Suma
 * Generates class with parameters customerId and password
 *
 */
public class LoginDto {
	
	@NotEmpty(message = "customerId cannot be null")
	private String customerId;
	@NotEmpty(message = "password cannot be null")
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
