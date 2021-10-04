package com.modular.bank.pojo;

import java.util.List;

import com.modular.bank.entity.TransactionAttr;

public class AccountResponse extends AccountAttr {
	
	List<TransactionAttr> transctions;

	public List<TransactionAttr> getTransctions() {
		return transctions;
	}

	public void setTransctions(List<TransactionAttr> transctions) {
		this.transctions = transctions;
	}

	

	
}
