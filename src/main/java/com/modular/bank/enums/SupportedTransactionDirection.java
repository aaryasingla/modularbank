package com.modular.bank.enums;

public enum SupportedTransactionDirection {
	
	
	IN(1), 
	OUT(2);
	
    private int value;

    SupportedTransactionDirection(int value) {
        this.value = value;
    }

    public int getChannelsType() {
        return value;
    }

    public static boolean contains(int value) {

        for (SupportedTransactionDirection direction : SupportedTransactionDirection.values()) {
            if (direction.value == value) {
                return true;
            }
        }

        throw new IllegalArgumentException("Invalid Transaction");
    }
	
}
