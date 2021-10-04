package com.modular.bank.enums;



public enum CustomErrorCode {
	
	INVALID_ACOUNT("Invalid currency.", 1001), 
	INVALID_CURRENCY("Invalid direction", 1002),
	INVALID_DIRECTION("Invalid amount ", 1003),
	INVALID_AMOUNT("Insufficient funds", 1004),
	ACCOUNT_MISSING("Description missing" , 1005);

    private String error;
    private Integer errorCode;

    CustomErrorCode(String error, Integer errorCode) {
        this.error = error;
        this.errorCode = errorCode;

    }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

   
}
