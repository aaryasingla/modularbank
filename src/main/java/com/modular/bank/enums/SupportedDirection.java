package com.modular.bank.enums;

import com.modular.bank.exception.GenericBadException;

public enum SupportedDirection {
	
	IN(1), 
	OUT(2);
	
    private int value;
    
    private static final int SIZE = values().length;

    SupportedDirection(int value) {
        this.value = value;
    }

    public int getDirection() {
        return value;
    }
    
    
    public static final String getDirection(Integer id) {
    	SupportedDirection[] supportedDirection;
        int i;
        
        supportedDirection = values();
        for(i = 0 ; i < SIZE ; i++) {
            if(supportedDirection[i].value == id)
                return supportedDirection[i].name();
        }
        throw new GenericBadException(CustomErrorCode.INVALID_DIRECTION.name(),CustomErrorCode.INVALID_DIRECTION.getErrorCode());
    }

    public static int contains(int value) {

        for (SupportedDirection currency : SupportedDirection.values()) {
            if (currency.value == value) {
                return currency.value;
            }
        }

       throw new GenericBadException(CustomErrorCode.INVALID_DIRECTION.name(),CustomErrorCode.INVALID_DIRECTION.getErrorCode());
    }
}
