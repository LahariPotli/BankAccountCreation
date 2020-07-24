package com.demo.bankaccount.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.bankaccount.dao.AccountDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.LoginDto;
import com.demo.bankaccount.dto.LoginResponseDto;
import com.demo.bankaccount.dto.RegisterRequestDto;
import com.demo.bankaccount.dto.RegisterResponseDto;
import com.demo.bankaccount.model.Account;
import com.demo.bankaccount.model.User;
import com.demo.bankaccount.service.UserService;


/**
 * @author Suma
 * This class is used for User related operations like userLogin and register User
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	UserService userService;
	
	
	
	@Override
	public RegisterResponseDto registerUser(RegisterRequestDto registerRequestDto) {
		
		RegisterResponseDto registerResponseDto = new RegisterResponseDto();
		
		logger.info("calculating age using the dateOfBirth");
	 int age = (int) ChronoUnit.YEARS.between(LocalDate.parse(registerRequestDto.getDateOfBirth()), LocalDate.now());
	 if(registerRequestDto.getPanNumber().length()!=10)
	 {
		 
		 registerResponseDto.setMessage("Please verify your PAN CARD Number");
		 registerResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		 return registerResponseDto;
	 }
	 logger.info("validating age");
	 if(age<18)
	 {
		 registerResponseDto.setMessage("To apply for an account your age should be greater than 18");
		 registerResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		 return registerResponseDto;
	 }
	
	 logger.info("verifying the existence of User");
	 Optional<User> userOptional = userDao.findByPanNumber(registerRequestDto.getPanNumber());
	 
	 
	 
	Boolean isExists =  userOptional.isPresent();
	if(isExists)
	{
		registerResponseDto.setMessage("You are already an account holder");
		registerResponseDto.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		 return registerResponseDto;
	}
	
	return saveUser(registerRequestDto, age);
		
		
	}
	
	private  RegisterResponseDto saveUser(RegisterRequestDto registerRequestDto, int age)
	{
		RegisterResponseDto registerResponseDto = new RegisterResponseDto();
		
		User user = new User();
		
		logger.info("Generating password and customerId");
		String pan = registerRequestDto.getPanNumber().substring(1, 4);
		String date = registerRequestDto.getDateOfBirth().substring(1, 3);
		String password = ("*").concat(pan).concat(date).concat("@");
		String id = registerRequestDto.getUserName().substring(1, 2);
		String mobile = registerRequestDto.getMobileNumber().substring(7, 9);
		String customerId = LocalDate.now().toString().substring(2, 4).concat(id).concat(mobile);
		
		logger.info("Saving User");
		user.setAge(age);
		user.setCustomerId(customerId);
		user.setDateOfBirth(LocalDate.parse(registerRequestDto.getDateOfBirth()));
		user.setMobileNumber(registerRequestDto.getMobileNumber());
		user.setOccupation(registerRequestDto.getOccupation());
		user.setPanNumber(registerRequestDto.getPanNumber());
		user.setPassword(password);
		user.setSalary(registerRequestDto.getSalary());
		user.setUserName(registerRequestDto.getUserName());
		userDao.save(user);
		
		logger.info("Generating accountNumber");
		
		String accountNo = LocalDate.now().toString().substring(0, 2);
		String ifsc = "AB025";
		String accountNumber = ifsc.concat(accountNo).concat(pan);
		double balance = 10000;
		
		logger.info("Saving Account");
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAccountType(registerRequestDto.getAccountType());
		account.setBalance(balance);
		account.setUser(user);
		accountDao.save(account);
		
		registerResponseDto.setCustomerId(user.getCustomerId());
		registerResponseDto.setPassword(user.getPassword());
		registerResponseDto.setMessage("Please find your customerId and password");
		registerResponseDto.setStatusCode(HttpStatus.CREATED.value());
		registerResponseDto.setUserId(user.getUserId());
		return registerResponseDto;
		
		
	}
	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		logger.info("Validating the request");
		
		if(loginDto.getCustomerId().isEmpty()||loginDto.getPassword().isEmpty())
		{
			loginResponseDto.setMessage("All fields are mandatory");
			loginResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return loginResponseDto;
		}
		Optional<User> userOptional  = userDao.findByCustomerIdAndPassword(loginDto.getCustomerId(),loginDto.getPassword());
		
		logger.info("verifying the existence of User");
		
		Boolean isExists = userOptional.isPresent();
		if(isExists)
		{
			loginResponseDto.setMessage("User logged in successfully");
			loginResponseDto.setStatusCode(HttpStatus.OK.value());
			return loginResponseDto;
			
		}
		
			loginResponseDto.setMessage("Invalid credentials!!Please verify ");
			loginResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			return loginResponseDto;	
	}
	
	
}
