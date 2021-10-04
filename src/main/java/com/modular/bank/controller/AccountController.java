package com.modular.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.modular.bank.pojo.AccountRequest;
import com.modular.bank.pojo.AccountResponse;
import com.modular.bank.pojo.TransactionRequest;
import com.modular.bank.pojo.TransactionResponse;
import com.modular.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService  acccountService;
	
	 @RequestMapping(value = "/create", method = RequestMethod.POST)
	 public ResponseEntity<AccountResponse> creatAccount(@RequestBody AccountRequest request ) {
		 
		return new ResponseEntity<>(acccountService.createAccount(request), HttpStatus.OK);
		 
	}
	 
	 @RequestMapping(value = "/{accountNumber}", method = RequestMethod.GET)
	 public ResponseEntity<AccountResponse> getAccount(@PathVariable(value = "accountNumber") String accountNumber ) {
		
		 return new ResponseEntity<>(acccountService.getAccount(accountNumber), HttpStatus.OK);
		 
	}
	 
	 @RequestMapping(value = "/{transaction}", method = RequestMethod.POST)
	 public ResponseEntity<TransactionResponse> getAccount(@RequestBody TransactionRequest request) {
		 return new ResponseEntity<>(acccountService.doTransction(request), HttpStatus.OK);
		 
	}

}
