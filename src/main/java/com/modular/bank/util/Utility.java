package com.modular.bank.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.modular.bank.pojo.AccountRequest;

public class Utility {

	public static String randomCode = "";
	
	public static String inTransction = "IN";
	
	public static String outTransction = "OUT";
	

	public static BigDecimal defaultBalance = new BigDecimal(1000);

	public static String getCustomerId() {
		randomCode = UUID.randomUUID().toString().substring(0, 5);
		return randomCode;
	}

	public static void validateAccount(AccountRequest account) {

	}

	public static String generateRandom() {
		int length = 12;
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return new String(digits);
	}
	
	public static String transctionIdgenerator(String accountno,String customerId) {
		  Date date = new Date();
		  long timeMilli = date.getTime();
		  
		  return accountno+"-"+timeMilli+"-"+customerId;
		  
		  
	}

}
