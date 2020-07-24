package com.demo.bankaccount.service;

import com.demo.bankaccount.dto.AccountListResponseDto;
/**
 * @author Haritha
 *
 */
public interface AccountService {
	/**
	 * This method is used to get the list of account details
	 * @param userId
	 * @return AccountListResponseDto
	 */
	AccountListResponseDto getAccountsByUserId(Long userId);
}
