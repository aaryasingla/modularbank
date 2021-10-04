package com.modular.bank.enums;

import com.modular.bank.exception.GenericBadException;

public enum SupportedCurrency {
	
	EUR(1), 
	SEK(2),
	GBP(3),
	USD(4);
	
    private int value;
    
    private static final int SIZE = values().length;

    SupportedCurrency(int value) {
        this.value = value;
    }

    public int getChannelsType() {
        return value;
    }
    
    
    public static final String getCurrency(Integer id) {
    	SupportedCurrency[] supportedCurrency;
        int i;
        
        supportedCurrency = values();
        for(i = 0 ; i < SIZE ; i++) {
            if(supportedCurrency[i].value == id)
                return supportedCurrency[i].name();
        }
                return null;
    }

    public static int contains(int value) {

        for (SupportedCurrency currency : SupportedCurrency.values()) {
            if (currency.value == value) {
                return currency.value;
            }
        }

       throw new GenericBadException(CustomErrorCode.INVALID_CURRENCY.name(),CustomErrorCode.INVALID_CURRENCY.getErrorCode());
    }
}
