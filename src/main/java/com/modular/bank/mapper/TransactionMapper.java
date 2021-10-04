package com.modular.bank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.modular.bank.entity.TransactionAttr;

@Mapper
public interface TransactionMapper {

	@Select("SELECT id, accountNumber, amount, currency, curr_balance,direction, description,createdDate  FROM transaction WHERE accountNumber = #{accountNumber}")
	List<TransactionAttr> getTransctions(String accoundId);
	
	@Select("SELECT id, accountNumber, amount, currency, direction, description  FROM transaction WHERE accountNumber = #{accountNumber}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "accountNumber", column = "accountNumber"), @Result(property = "amount", column = "amount"),
			@Result(property = "currency", column = "currency"), @Result(property = "direction", column = "direction"),
			@Result(property = "description", column = "description") })
    TransactionAttr  getTransaction(String accoundId);
	
	@Insert("INSERT INTO transaction (accountNumber, amount, curr_balance,currency, description, direction) VALUES ( #{accountNumber}, #{amount}, #{curr_balance}, #{currency}, #{description}, #{direction}) ")
	void doTransaction(TransactionAttr account);

}
