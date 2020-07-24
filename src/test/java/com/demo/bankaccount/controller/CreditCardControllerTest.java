package com.demo.bankaccount.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.bankaccount.dto.CreditCardResponseDto;
import com.demo.bankaccount.dto.CreditCardType;
import com.demo.bankaccount.service.CreditCardService;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CreditCardControllerTest {
	@Mock
	CreditCardService creditcardservice;
	MockMvc mockMvc;
	ObjectMapper objectMapper;
	@InjectMocks
	CreditCardController creditcardcontroller;
	CreditCardResponseDto credircardresponsedto;
	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();

		mockMvc = MockMvcBuilders.standaloneSetup(creditcardcontroller).build();

	}
	@Test
	public void getcreditcarddetailsbyuserId() throws Exception {
		CreditCardResponseDto credircardresponsedto=new CreditCardResponseDto();
		credircardresponsedto.setMessage("your card is PLATINUM.");
		credircardresponsedto.setCreditCardType(CreditCardType.PLATINUM);
		credircardresponsedto.setStatusCode(201);
		// given
				when(creditcardservice.getCreditCardDetails(eq(1L))).thenReturn(credircardresponsedto);

				mockMvc.perform(post("/users/{userId}/creditcard", 1L).contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(credircardresponsedto))).andExpect(status().isOk())
						.andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
				verify(creditcardservice).getCreditCardDetails(eq(1L));
			}
		
	}





