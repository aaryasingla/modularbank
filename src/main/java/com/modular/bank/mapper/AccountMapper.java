package com.modular.bank.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.modular.bank.entity.AccountDao;


@Mapper
public interface AccountMapper {
	 @Insert("INSERT INTO account (accountNumber, customerId, balance, currency, country) VALUES ( #{accountNumber}, #{customerId}, #{balance}, #{currency}, #{country}) ")
	 void createAccount(AccountDao account);
	 
	 @Select("SELECT * FROM account  WHERE accountNumber = #{accountId} ") 
	 @Results(value={
			    @Result(property="id", column ="id" ),
		        @Result(property="accountNumber", column ="accountNumber" ),
		        @Result(property="customerId", column ="customerId" ),
		        @Result(property="balance", column ="balance" ),
		        @Result(property="currency", column ="currency" ),
		        @Result(property="country", column ="country" ),
		        @Result(property="transaction", column="accountNumber", javaType= List.class, many=@Many(select="com.modular.bank.mapper.TransactionMapper.getTransctions"))
		    })
	 public AccountDao getAccount(String accountId);
	 
	 
	 @Update("Update account set balance= #{currentAmount} where accountNumber=#{accountid}")
	 public void updatePerson(BigDecimal currentAmount,String accountid );

	

}