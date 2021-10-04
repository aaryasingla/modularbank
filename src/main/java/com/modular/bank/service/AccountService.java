package com.modular.bank.service;

import com.modular.bank.pojo.AccountRequest;
import com.modular.bank.pojo.AccountResponse;
import com.modular.bank.pojo.TransactionRequest;
import com.modular.bank.pojo.TransactionResponse;

public interface AccountService {

	AccountResponse createAccount(AccountRequest account);

	AccountResponse getAccount(String account);
	
	TransactionResponse doTransction(TransactionRequest transactionRequest);
}
