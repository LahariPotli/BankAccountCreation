package com.demo.bankaccount.dto;

import java.util.List;
/**
* @author haritha
*
*/
public class AccountListResponseDto {
	private String message;
	private Integer statusCode;
List<AccountResponseDto> accountResponseDto;
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
public List<AccountResponseDto> getAccountResponseDto() {
	return accountResponseDto;
}
public void setAccountResponseDto(List<AccountResponseDto> accountResponseDto) {
	this.accountResponseDto = accountResponseDto;
}
}
