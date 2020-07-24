package com.demo.bankaccount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.bankaccount.controller.AccountController;
import com.demo.bankaccount.controller.CreditCardController;
import com.demo.bankaccount.controller.UserController;

@SpringBootTest
class BankAccountCreationApplicationTests {
	@Autowired
	CreditCardController creditCardController;
	@Autowired
	AccountController accountController;
	@Autowired
	UserController userController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(creditCardController).isNotNull();
	}
	@Test
	public void contexLoads1() throws Exception {
		assertThat(accountController).isNotNull();
	}
	@Test
	public void contexLoads2() throws Exception {
		assertThat(userController).isNotNull();
	}



}
