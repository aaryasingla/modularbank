package com.modular.bank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.modular.bank.entity.AccountDao;
import com.modular.bank.entity.TransactionAttr;
import com.modular.bank.enums.CustomErrorCode;
import com.modular.bank.enums.SupportedCountry;
import com.modular.bank.enums.SupportedCurrency;
import com.modular.bank.exception.GenericBadException;
import com.modular.bank.exception.ModularBankTransactionException;
import com.modular.bank.mapper.AccountMapper;
import com.modular.bank.mapper.TransactionMapper;
import com.modular.bank.pojo.AccountRequest;
import com.modular.bank.pojo.AccountResponse;
import com.modular.bank.pojo.TransactionRequest;
import com.modular.bank.pojo.TransactionResponse;
import com.modular.bank.util.Utility;

@Service
public class AccountServiceImpl implements AccountService  {

	@Autowired 
	private AccountMapper accountMapper;
	
	@Autowired
	private TransactionMapper transctionMapper;
	
	@Autowired
	private RabbitMQSender sender;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW )
	public AccountResponse createAccount(AccountRequest account) {
		AccountDao acc= new AccountDao();
		acc.setAccountNumber(Utility.generateRandom());
		acc.setBalance(Utility.defaultBalance);
		acc.setCountry(SupportedCountry.contains(Integer.parseInt(account.getCountry())));
		acc.setCurrency(SupportedCurrency.contains(Integer.parseInt(account.getCurrency())));
		acc.setCustomerId(Utility.getCustomerId()+"-"+SupportedCountry.contains(Integer.parseInt(account.getCountry())));

		accountMapper.createAccount(acc);
		
		AccountResponse response = getAccount(acc.getAccountNumber());
		sender.send(acc);
		return response;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	public AccountResponse getAccount(String  accountNumber) {
		
		AccountDao dao = accountMapper.getAccount(accountNumber);
		if(dao==null)
			throw new GenericBadException(CustomErrorCode.INVALID_ACOUNT.name(),CustomErrorCode.INVALID_ACOUNT.getErrorCode());
		AccountResponse response = new AccountResponse();
		response.setAccountId(dao.getAccountNumber());
		response.setCustomerId(dao.getCustomerId());
		
		response.setTransctions(dao.getTransaction());
		return response;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED,
    rollbackFor = ModularBankTransactionException.class)
	public TransactionResponse doTransction(TransactionRequest transactionRequest) {
		TransactionResponse response = new TransactionResponse();
		AccountDao dao = accountMapper.getAccount(transactionRequest.getAccountId());
		if (dao==null)
				throw new ModularBankTransactionException(CustomErrorCode.ACCOUNT_MISSING.name(),CustomErrorCode.ACCOUNT_MISSING.getErrorCode());
		dao.setAccountNumber(transactionRequest.getAccountId());
		dao.setBalance(dao.getBalance()==null?new BigDecimal(0):dao.getBalance());
		BigDecimal currBalance =null;
		
		if (transactionRequest.getDirection().equalsIgnoreCase(Utility.outTransction) ) {
			if(dao.getBalance().doubleValue() >= transactionRequest.getAmount().doubleValue()) {
				currBalance = new BigDecimal(dao.getBalance().doubleValue() - transactionRequest.getAmount().doubleValue());
			} else {
				throw new ModularBankTransactionException(CustomErrorCode.INVALID_AMOUNT.name(),CustomErrorCode.INVALID_AMOUNT.getErrorCode());
			}
			
		} else if (transactionRequest.getDirection().equalsIgnoreCase(Utility.inTransction)) {
			currBalance = new BigDecimal(dao.getBalance().doubleValue() + transactionRequest.getAmount().doubleValue());
		} else {
			throw new ModularBankTransactionException(CustomErrorCode.INVALID_DIRECTION.name(),CustomErrorCode.INVALID_DIRECTION.getErrorCode());
		}
		
		TransactionAttr attr = new TransactionAttr();
		attr.setAmount(transactionRequest.getAmount());
		attr.setCurr_balance(currBalance);
		attr.setAccountNumber(Long.parseLong(dao.getAccountNumber()));
		attr.setCurrency(dao.getCurrency());
		attr.setDescription(transactionRequest.getDescription());
		attr.setDirection(transactionRequest.getDirection());
		accountMapper.updatePerson(currBalance, dao.getAccountNumber());
		transctionMapper.doTransaction(attr);
		response.setTransaction(transctionMapper.getTransctions(dao.getAccountNumber()));
		sender.send(attr);
		return response;
		
	}
}
