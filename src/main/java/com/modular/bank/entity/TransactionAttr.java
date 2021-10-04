package com.modular.bank.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TransactionAttr {
	
	private Long id;
	
	private Long accountNumber;
	
	private BigDecimal amount;
	
	private BigDecimal curr_balance;
	
	private int currency;
	
	private String description;
	
	private String direction;
	
	private Timestamp createdDate;
	
	@JsonIgnore
	private AccountDao accountDao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public BigDecimal getCurr_balance() {
		return curr_balance;
	}

	public void setCurr_balance(BigDecimal curr_balance) {
		this.curr_balance = curr_balance;
	}

	
	
}
