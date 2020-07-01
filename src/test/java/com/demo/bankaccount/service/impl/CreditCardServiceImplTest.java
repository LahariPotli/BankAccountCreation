package com.demo.bankaccount.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.bankaccount.dao.CreditCardDao;
import com.demo.bankaccount.dao.UserDao;
import com.demo.bankaccount.dto.CreditCardResponseDto;
import com.demo.bankaccount.dto.CreditCardType;
import com.demo.bankaccount.model.User;



@ExtendWith(MockitoExtension.class)
public class CreditCardServiceImplTest {
	@Mock
	CreditCardDao creditcarddao;
	@InjectMocks
	CreditCardServiceImpl creditcardserviceimpl;
	@Mock
	UserDao userdao;
	 User user;
	
	@BeforeEach
	public void setUp() {
		User user=new User();
		

	}
	@Test
	public void getcreditcarddetailsbyuserid() {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		credircardresponsedto.setMessage("your credit card type is Platinum");
		credircardresponsedto.setStatusCode(201);
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		
		
		
		creditcardserviceimpl.getCreditCardDetails(1L);
		
		verify(userdao).findByUserId(1L);
	}
}
	

	
	
	


