package com.demo.bankaccount.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankaccount.dao.AccountDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.AccountListResponseDto;
import com.demo.bankaccount.dto.AccountResponseDto;
import com.demo.bankaccount.model.Account;
import com.demo.bankaccount.model.User;
import com.demo.bankaccount.service.AccountService;

/**
 * @author Haritha
 *
 */

@Service
public class AccountServiceImpl implements AccountService {
	static Log logger = LogFactory.getLog(AccountServiceImpl.class);
	@Autowired
	AccountDao accountDao;
	@Autowired
	UserDao userDao;

	/**
	 * this method is used to get the account details by userId
	 */
	@Override
	public AccountListResponseDto getAccountsByUserId(Long userId) {
		logger.info("Inside getAccountsByUserId method ");
		AccountListResponseDto accountListResponseDto = new AccountListResponseDto();

		Optional<User> user = userDao.findByUserId(userId);

		if (!user.isPresent()) {
			logger.info("userId is not valid");
			accountListResponseDto.setMessage("incorrect userId..Please verify userId");
			accountListResponseDto.setStatusCode(404);
			return accountListResponseDto;
		}
		Optional<List<Account>> accounts = accountDao.findByUser(user.get());
		if (!accounts.isPresent()) {
			accountListResponseDto.setMessage("No accounts for this userId");
			accountListResponseDto.setStatusCode(404);
			return accountListResponseDto;
		}

		List<AccountResponseDto> accountResponseDto = accounts.get().stream()
				.map(account -> getAccountResponseDto(account)).collect(Collectors.toList());
		accountListResponseDto.setAccountResponseDto(accountResponseDto);
		accountListResponseDto.setMessage("Please find the account details");
		accountListResponseDto.setStatusCode(200);
		return accountListResponseDto;
	}

	private AccountResponseDto getAccountResponseDto(Account account) {
		logger.info("Inside getAccountResponseDto method ");
		AccountResponseDto accountResponseDto = new AccountResponseDto();
		BeanUtils.copyProperties(account, accountResponseDto);
		return accountResponseDto;
	}
}
