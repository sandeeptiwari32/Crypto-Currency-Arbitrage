package com.crypto.arbitrage.common;

public enum Currency {
	BITCOIN("Bitcoin"),
	ETHEREUM("Ethereum"),
	CARDANO("Cardano"),
	LITECOIN("Litecoin"),
	BITCOIN_CASH("Bitcoin Cash");

	String currency;
	Currency(String currency) {
		this.currency = currency;
	}
	
	public static boolean contains(String currencyName) {
		for (Currency c : Currency.values()) {
	        if (c.currency.equals(currencyName)) {
	            return true;
	        }
	    }

	    return false;	
	}
	
	public static Currency getInstance(String currencyName) {
		for (Currency c : Currency.values()) {
	        if (c.currency.equals(currencyName)) {
	            return c;
	        }
	    }

	    return null;
	}
}
