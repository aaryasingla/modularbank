package com.modular.bank.pojo;

import java.util.List;

import com.modular.bank.entity.TransactionAttr;

public class TransactionResponse {

	List<TransactionAttr> transaction;

	public List<TransactionAttr> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<TransactionAttr> transaction) {
		this.transaction = transaction;
	}

	
}
