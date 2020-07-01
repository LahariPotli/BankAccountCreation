package com.demo.bankaccount.service;

import com.demo.bankaccount.dto.CreditCardResponseDto;

/**
 * @author Lahari_Reddy
 *
 */
public interface CreditCardService {
	/**
	 * this method returns credit card details by userid and ssalary
	 * 
	 * @param userId
	 * @return credit card details
	 */
	CreditCardResponseDto getCreditCardDetails(Long userId);

}
