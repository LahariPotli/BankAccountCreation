package com.demo.bankaccount.controller;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankaccount.dto.AccountListResponseDto;

import com.demo.bankaccount.service.AccountService;

/**
 * @author Haritha
 *This controller is used to display account details based on the userId
 */

@RestController
public class AccountController {
	static Log logger = LogFactory.getLog(AccountController.class);
@Autowired
AccountService accountService;

/**
 * This method is used to get the account details by the userId
 * @param userId
 * @return account details
 */
@GetMapping("/users/{userId}/accounts")
public ResponseEntity<AccountListResponseDto> getAccountDetailsByUserId(@PathVariable("userId") Long userId) {
	logger.info("Inside AccountDetails method ");
	return new ResponseEntity<> (accountService.getAccountsByUserId(userId),HttpStatus.OK);
}
}
