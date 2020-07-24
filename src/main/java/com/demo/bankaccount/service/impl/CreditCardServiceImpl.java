package com.demo.bankaccount.service.impl;

import java.time.LocalDate;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;


import com.demo.bankaccount.dao.CreditCardDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.CreditCardResponseDto;
import com.demo.bankaccount.dto.CreditCardType;
import com.demo.bankaccount.exception.ResourceNotFoundException;
import com.demo.bankaccount.model.CreditCard;
import com.demo.bankaccount.model.User;
import com.demo.bankaccount.service.CreditCardService;

/**
 * @author Lahari_Reddy
 *
 */
@Repository
public class CreditCardServiceImpl implements CreditCardService {
	private static Log logger = LogFactory.getLog(CreditCardServiceImpl.class);
	@Autowired
	CreditCardDao creditCardDao;
	@Autowired
	UserDao userDao;

	/**
	 * this method save and return credit card details based on salary of the user
	 * if exists.
	 */
	@Override
	public CreditCardResponseDto getCreditCardDetails(Long userId) {
		logger.info("Inside get credit card details in creditcard service impl");

		CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto();
		logger.info("verifying user existence");
		Optional<User> useroptional = userDao.findByUserId(userId);
			

		if (!useroptional.isPresent())
		{
			throw new ResourceNotFoundException("User is not found with userId");
		}
		CreditCard creditcard = new CreditCard();

		if (useroptional.get().getSalary() >= 50000) {
			logger.info("user exists and salary is greater than fiftythousand");

			creditcard.setCreditCardType(CreditCardType.PLATINUM);
			creditcard.setDate(LocalDate.now());
			creditcard.setUser(useroptional.get());

			creditCardResponseDto.setCreditCardType(CreditCardType.PLATINUM);
			creditCardResponseDto.setMessage("You have successfully applied for platinum credit card");
			creditCardResponseDto.setStatusCode(HttpStatus.CREATED.value());
			
			creditCardDao.save(creditcard);
			return creditCardResponseDto;
		}
		if (useroptional.get().getSalary() < 50000 && useroptional.get().getSalary() > 30000) {
			logger.info("user exists and salary is in between thirtythousand to fifty thousand ");

			creditcard.setCreditCardType(CreditCardType.GOLD);

			creditcard.setUser(useroptional.get());
			creditcard.setDate(LocalDate.now());
			creditCardResponseDto.setCreditCardType(CreditCardType.GOLD);
			creditCardResponseDto.setMessage("You have successfully applied for gold credit card");
			creditCardResponseDto.setStatusCode(HttpStatus.CREATED.value());
			logger.info("save creditCard");
			creditCardDao.save(creditcard);
			return creditCardResponseDto;
		}
		if (useroptional.get().getSalary() < 30000) {
			logger.info("user exists and salary is less than thirty thousand ");
			
			creditcard.setCreditCardType(CreditCardType.SILVER);
			creditcard.setUser(useroptional.get());
			creditcard.setDate(LocalDate.now());
			creditCardResponseDto.setCreditCardType(CreditCardType.SILVER);
			creditCardResponseDto.setMessage("You have successfully applied for silver credit card");
			creditCardResponseDto.setStatusCode(HttpStatus.CREATED.value());

			creditCardDao.save(creditcard);
			return creditCardResponseDto;
		}

		return creditCardResponseDto;
	}

}
