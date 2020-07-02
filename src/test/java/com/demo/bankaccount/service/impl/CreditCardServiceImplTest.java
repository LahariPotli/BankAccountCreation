package com.demo.bankaccount.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.time.LocalDate;
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
import com.demo.bankaccount.model.CreditCard;
import com.demo.bankaccount.model.User;



@ExtendWith(MockitoExtension.class)
public class CreditCardServiceImplTest {
	@Mock
	CreditCardDao creditcarddao;
	@InjectMocks
	CreditCardServiceImpl creditcardserviceimpl;
	@Mock
	UserDao userdao;
	
	@Mock
	CreditCardDao creditCardDao;
	 User user;
	
	@BeforeEach
	public void setUp() {
		
		

	}
	@Test
	public void getcreditcarddetailsbyuserid() {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		User user=new User();
		user = new User();
		user.setAge(20);
		user.setCustomerId("test123");
		user.setDateOfBirth(LocalDate.parse("2020-06-30"));
		user.setMobileNumber("486759854");
		user.setOccupation("engineer");
		user.setPanNumber("testPAN123");
		user.setPassword("test123");
		user.setSalary(20000);
		user.setUserId(1L);
		user.setUserName("testName");
		
		credircardresponsedto.setMessage("your credit card type is Platinum");
		credircardresponsedto.setStatusCode(201);
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardId(1L);
		creditCard.setCreditCardType(CreditCardType.PLATINUM);
		creditCard.setDate(LocalDate.now());
		creditCard.setUser(user);
			
		when(userdao.findByUserId(1L)).thenReturn(Optional.of(user));
		creditcardserviceimpl.getCreditCardDetails(1L);
		assertThat(Optional.of(user).get().getSalary()<30000).isTrue();
		
		verify(userdao).findByUserId(1L);
		verify(creditCardDao).save(any(CreditCard.class));
		
		
	}
	
	@Test
	public void getcreditcarddetailsbyuserid1() {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		User user=new User();
		user = new User();
		user.setAge(20);
		user.setCustomerId("test123");
		user.setDateOfBirth(LocalDate.parse("2020-06-30"));
		user.setMobileNumber("486759854");
		user.setOccupation("engineer");
		user.setPanNumber("testPAN123");
		user.setPassword("test123");
		user.setSalary(60000);
		user.setUserId(2L);
		user.setUserName("testName");
		
		credircardresponsedto.setMessage("your credit card type is Platinum");
		credircardresponsedto.setStatusCode(201);
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardId(2L);
		creditCard.setCreditCardType(CreditCardType.PLATINUM);
		creditCard.setDate(LocalDate.now());
		creditCard.setUser(user);
			
		when(userdao.findByUserId(2L)).thenReturn(Optional.of(user));
		creditcardserviceimpl.getCreditCardDetails(2L);
		assertThat(Optional.of(user).get().getSalary()>=50000).isTrue();
		
		verify(userdao).findByUserId(2L);
		verify(creditCardDao).save(any(CreditCard.class));
		
		
	}
	
	@Test
	public void getcreditcarddetailsbyuserid2() {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		User user=new User();
		user = new User();
		user.setAge(20);
		user.setCustomerId("test123");
		user.setDateOfBirth(LocalDate.parse("2020-06-30"));
		user.setMobileNumber("486759854");
		user.setOccupation("engineer");
		user.setPanNumber("testPAN123");
		user.setPassword("test123");
		user.setSalary(40000);
		user.setUserId(2L);
		user.setUserName("testName");
		
		credircardresponsedto.setMessage("your credit card type is Platinum");
		credircardresponsedto.setStatusCode(201);
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardId(2L);
		creditCard.setCreditCardType(CreditCardType.PLATINUM);
		creditCard.setDate(LocalDate.now());
		creditCard.setUser(user);
			
		when(userdao.findByUserId(2L)).thenReturn(Optional.of(user));
		creditcardserviceimpl.getCreditCardDetails(2L);
		assertThat(Optional.of(user).get().getSalary()<50000 && Optional.of(user).get().getSalary()>30000).isTrue();
		
		verify(userdao).findByUserId(2L);
		verify(creditCardDao).save(any(CreditCard.class));
		
		
	}
	
	
	@Test
	public void getcreditcarddetailsbyuserid3() {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		User user=new User();
		user = new User();
		user.setAge(20);
		user.setCustomerId("test123");
		user.setDateOfBirth(LocalDate.parse("2020-06-30"));
		user.setMobileNumber("486759854");
		user.setOccupation("engineer");
		user.setPanNumber("testPAN123");
		user.setPassword("test123");
		user.setSalary(40000);
		user.setUserId(2L);
		user.setUserName("testName");
		
		credircardresponsedto.setMessage("your credit card type is Platinum");
		credircardresponsedto.setStatusCode(201);
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardId(2L);
		creditCard.setCreditCardType(CreditCardType.PLATINUM);
		creditCard.setDate(LocalDate.now());
		creditCard.setUser(user);
			
		when(userdao.findByUserId(2L)).thenReturn(Optional.ofNullable(user));
		creditcardserviceimpl.getCreditCardDetails(2L);
		
		verify(userdao).findByUserId(2L);
		
		
	}
}
	

	
	
	


