package com.demo.bankaccount.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.demo.bankaccount.dao.AccountDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.AccountResponseDto;
import com.demo.bankaccount.dto.AccountType;
import com.demo.bankaccount.model.Account;
import com.demo.bankaccount.model.User;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
	@Mock
	AccountDao accountDao;
	@Mock
	UserDao userDao;
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	User user;

	@BeforeEach
	public void setUp() {
		user = new User();
	}

	@Test
	public void getAccountsByUserId() {
		List<Account> accountList = new ArrayList<>();
		AccountResponseDto responseDto = new AccountResponseDto();
		responseDto.setAccountNumber("9876899098");
		responseDto.setAccountType(AccountType.SAVING);
		responseDto.setBalance(50000);
		when(userDao.findByUserId(1L)).thenReturn(Optional.of(user));
		when(accountDao.findByUser(Mockito.any(User.class))).thenReturn(Optional.of(accountList));
		accountServiceImpl.getAccountsByUserId(1L);
		verify(accountDao).findByUser(user);
	}

}
