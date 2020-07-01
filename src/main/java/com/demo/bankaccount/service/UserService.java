package com.demo.bankaccount.service;

import javax.validation.Valid;

import com.demo.bankaccount.dto.LoginDto;
import com.demo.bankaccount.dto.LoginResponseDto;
import com.demo.bankaccount.dto.RegisterRequestDto;
import com.demo.bankaccount.dto.RegisterResponseDto;

/**
 * @author Suma
 *
 */
public interface UserService {

	/**
	 * This method is used to register user
	 * @param registerRequestDto
	 * @return RegisterResponseDto
	 */
	public RegisterResponseDto registerUser( RegisterRequestDto registerRequestDto);
	
	//public RegisterResponseDto saveUser(RegisterRequestDto registerRequestDto, int age);

	public LoginResponseDto loginUser(@Valid LoginDto loginDto);

}
