package com.modular.bank.enums;

public enum SupportedCountry {
	
	EUR("EUR", 1), 
	SEK("SEK", 3),
	GBP("GBP", 4),
	USD("USD", 5);

    private String country;
    private Integer countryCode;

    SupportedCountry(String country, Integer countryCode) {
        this.country = country;
        this.countryCode = countryCode;

    }

    public static String contains(Integer countryCode) {

        for (SupportedCountry country : SupportedCountry.values()) {
            if (country.countryCode.equals(countryCode))
                return country.country;
        }

        return SupportedCountry.EUR.country;
    }

}
