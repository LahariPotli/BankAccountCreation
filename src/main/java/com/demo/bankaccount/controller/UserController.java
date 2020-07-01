package com.demo.bankaccount.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankaccount.dto.LoginDto;
import com.demo.bankaccount.dto.LoginResponseDto;
import com.demo.bankaccount.dto.RegisterRequestDto;
import com.demo.bankaccount.dto.RegisterResponseDto;
import com.demo.bankaccount.service.UserService;

/**
 * @author Suma
 * This controller is used to send register request and login request from user 
 * and get a response based on the request
 *
 */
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * This method is used to register User and get RegisterResponseDto with customerId,password
	 * @param registerRequestDto
	 * @return RegisterResponseDto
	 */
	@PostMapping("/users")
	public ResponseEntity<RegisterResponseDto> registerUser(@Valid @RequestBody RegisterRequestDto registerRequestDto)
	{
		return new ResponseEntity<>(userService.registerUser(registerRequestDto),HttpStatus.OK);
	}
	
	/**
	 * This method is used for logging in User 
	 * @param loginDto
	 * @return LoginResponseDto with parameters message and statusCode
	 */
	@PostMapping("/users/login")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto loginDto)
	{
		return new ResponseEntity<>(userService.loginUser(loginDto),HttpStatus.OK);
	}

}
