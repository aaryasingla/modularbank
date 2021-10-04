package com.modular.bank;

import com.modular.bank.entity.AccountDao;
import com.modular.bank.enums.SupportedCountry;
import com.modular.bank.enums.SupportedCurrency;
import com.modular.bank.mapper.AccountMapper;
import com.modular.bank.pojo.AccountRequest;
import com.modular.bank.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2


public class ModularbankApplication {
	@Autowired
	private AccountMapper accountMapper;
	public static void main(String[] args) {
		SpringApplication.run(ModularbankApplication.class, args);
		
	}



}
