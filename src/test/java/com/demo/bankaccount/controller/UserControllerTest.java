package com.demo.bankaccount.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.bankaccount.dto.AccountType;
import com.demo.bankaccount.dto.LoginDto;
import com.demo.bankaccount.dto.LoginResponseDto;
import com.demo.bankaccount.dto.RegisterRequestDto;
import com.demo.bankaccount.dto.RegisterResponseDto;
import com.demo.bankaccount.model.User;
import com.demo.bankaccount.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
    UserService userService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    UserController userController;

    LoginDto loginDto;
    LoginResponseDto loginResponseDto;
    
    RegisterRequestDto registerRequestDto;
    
    RegisterResponseDto registerResponseDto;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        
        
    }

    	@Test
        public void userLoginTest() throws Exception
        {
    		LoginDto loginDto = new LoginDto();
    		
    		loginDto.setCustomerId("1234");
    		loginDto.setPassword("test");
    		
           LoginResponseDto loginResponseDto = new LoginResponseDto();
           
           loginResponseDto.setMessage("user logged in successfully!!");
           loginResponseDto.setStatusCode(200);
           
            when(userService.loginUser(any(LoginDto.class))).thenReturn(loginResponseDto);
            mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(loginDto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
    
            verify(userService).loginUser(any(LoginDto.class));
        }

    	@Test
    	public void registerUserTest()  throws Exception
    	{
    		RegisterRequestDto registerRequestDto = new RegisterRequestDto();
    		registerRequestDto.setAccountType(AccountType.SAVING);
    		registerRequestDto.setDateOfBirth("2000-06-30");
    		registerRequestDto.setMobileNumber("98328756783");
    		registerRequestDto.setOccupation("engineer");
    		registerRequestDto.setPanNumber("BSPKJ4248K");
    		registerRequestDto.setSalary(20000);
    		registerRequestDto.setUserName("test");

    		RegisterResponseDto registerResponseDto = new RegisterResponseDto();

    		registerResponseDto.setCustomerId("@F6WEN82");
    		registerResponseDto.setMessage("Please find your customerId and password");
    		registerResponseDto.setPassword("test@123");
    		registerResponseDto.setStatusCode(201);
    		registerResponseDto.setUserId(1L);

    		User user = new User();
    		BeanUtils.copyProperties(registerRequestDto, user);
    		user.setAge(20);
    		user.setUserId(1L);
    		user.setCustomerId(registerResponseDto.getCustomerId());
    		user.setPassword(registerResponseDto.getPassword());
    		
    		 when(userService.registerUser(any(RegisterRequestDto.class))).thenReturn(registerResponseDto);
             mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE)
                     .content(objectMapper.writeValueAsString(registerRequestDto)))
                     .andExpect(status().isOk())
                     .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
     
             verify(userService).registerUser(any(RegisterRequestDto.class));
    		
    	}
        
    }