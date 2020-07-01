package com.demo.bankaccount.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.bankaccount.dto.AccountListResponseDto;
import com.demo.bankaccount.dto.AccountResponseDto;
import com.demo.bankaccount.dto.AccountType;
import com.demo.bankaccount.service.AccountService;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
	@Mock
	AccountService accountService;
	MockMvc mockMvc;
	ObjectMapper objectMapper;
	@InjectMocks
	AccountController accountController;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

	}

	@Test
	public void getAccountsByUserId() throws Exception

	{
		AccountListResponseDto accountListResponseDto = new AccountListResponseDto();

		AccountResponseDto accountResponseDto = new AccountResponseDto();
		accountResponseDto.setAccountNumber("986556787");
		accountResponseDto.setAccountType(AccountType.SAVING);
		accountResponseDto.setBalance(50000);
		List<AccountResponseDto> accountResponseDtoList = new ArrayList<>();
		accountResponseDtoList.add(accountResponseDto);
		accountListResponseDto.setMessage("Please find the account details");
		accountListResponseDto.setStatusCode(200);
		accountListResponseDto.setAccountResponseDto(accountResponseDtoList);
		when(accountService.getAccountsByUserId(1L)).thenReturn(accountListResponseDto);

		mockMvc.perform(get("/users/{userId}/accounts", 1L).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
		verify(accountService).getAccountsByUserId(1L);
	}
}
