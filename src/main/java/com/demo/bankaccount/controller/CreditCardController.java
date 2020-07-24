package com.demo.bankaccount.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankaccount.dto.CreditCardResponseDto;
import com.demo.bankaccount.service.CreditCardService;

/**
 * @author Lahari_Reddy
 *
 */
@RestController
public class CreditCardController {
	private static Log logger = LogFactory.getLog(CreditCardController.class);

	@Autowired
	CreditCardService creditCardService;

	/**
	 * This method save and return credit card details based on salary and user id.
	 * 
	 * @param userId
	 * @return credit card details by userid
	 */
	@PostMapping("/users/{userId}/creditcard")
	public ResponseEntity<CreditCardResponseDto> getcreditcardetailsbyuserId(@PathVariable("userId") Long userId) {
		logger.info("Inside getCreditCardDetailsByUserid method in controller");

		return new ResponseEntity<>(creditCardService.getCreditCardDetails(userId), HttpStatus.OK);
	}

}
