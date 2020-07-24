package com.demo.bankaccount.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Lahari_Reddy
 *
 */
public class CreditCardResponseDto {
	@Enumerated(EnumType.STRING)
	private CreditCardType creditCardType;

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	String message;
	Integer statusCode;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
