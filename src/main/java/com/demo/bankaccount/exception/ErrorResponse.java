package com.demo.bankaccount.exception;

public class ErrorResponse 
{
public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
private String message;
private Integer statusCode ;
   
    
}