package com.demo.bankaccount.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.demo.bankaccount.dto.CreditCardType;

@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long creditCardId;
	@Enumerated(EnumType.STRING)
	private CreditCardType creditCardType;
	private LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	
	public Long getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
