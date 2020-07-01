package com.demo.bankaccount.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.demo.bankaccount.dao.AccountDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.AccountType;
import com.demo.bankaccount.dto.LoginDto;
import com.demo.bankaccount.dto.LoginResponseDto;
import com.demo.bankaccount.dto.RegisterRequestDto;
import com.demo.bankaccount.dto.RegisterResponseDto;
import com.demo.bankaccount.model.User;
import com.demo.bankaccount.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	AccountDao accountDao;

	LoginResponseDto loginResponseDto;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void registerUserTest() {
		RegisterRequestDto registerRequestDto = new RegisterRequestDto();
		registerRequestDto.setAccountType(AccountType.SAVING);
		registerRequestDto.setDateOfBirth("2000-06-30");
		registerRequestDto.setMobileNumber("98328756783");
		registerRequestDto.setOccupation("engineer");
		registerRequestDto.setPanNumber("BSPKJ4248K");
		registerRequestDto.setSalary(20000);
		registerRequestDto.setUserName("test");

		RegisterResponseDto registerResponseDto = new RegisterResponseDto();

		registerResponseDto.setCustomerId("@F6WEN82");
		registerResponseDto.setMessage("Please find your customerId and password");
		registerResponseDto.setPassword("test@123");
		registerResponseDto.setStatusCode(201);
		registerResponseDto.setUserId(1L);

		User user = new User();
		BeanUtils.copyProperties(registerRequestDto, user);
		user.setAge(20);
		user.setUserId(1L);
		user.setCustomerId(registerResponseDto.getCustomerId());
		user.setPassword(registerResponseDto.getPassword());

		userServiceImpl.registerUser(registerRequestDto);
		
		assertEquals(20,
				(int) ChronoUnit.YEARS.between(LocalDate.parse(registerRequestDto.getDateOfBirth()), LocalDate.now()));
		verify(userDao).findByPanNumber("BSPKJ4248K");
	}

	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setCustomerId("TEST123");
		loginDto.setPassword("test123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("Employee logged in");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		user.setAge(20);
		user.setCustomerId("TEST123");
		user.setDateOfBirth(LocalDate.parse("2020-06-30"));
		user.setMobileNumber("834769854");
		user.setOccupation("engineer");
		user.setPanNumber("test1234");
		user.setPassword("test123");
		user.setSalary(50000);
		user.setUserId(1L);
		user.setUserName("testUser");

		assertThat(!(loginDto.getCustomerId().isEmpty() && loginDto.getPassword().isEmpty()));

		when(userDao.findByCustomerIdAndPassword("TEST123", "test123")).thenReturn(Optional.of(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByCustomerIdAndPassword("TEST123", "test123");

	}

}