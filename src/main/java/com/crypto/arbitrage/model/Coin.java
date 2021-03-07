package com.crypto.arbitrage.model;

import com.crypto.arbitrage.common.Currency;
import com.crypto.arbitrage.common.Exchanges;

public class Coin implements Comparable<Coin> {
	Double price;
	Currency currency;
	Exchanges exchange;
	public Coin(String price, Currency currency, Exchanges exchange) {
		StringBuilder sb = new StringBuilder();
		for(char c: price.toCharArray()) {
			if(Character.isDigit(c) || c=='.') {
				sb.append(c);
			}
		}
		
		this.price = Double.parseDouble(sb.toString());
		this.currency = currency;
		this.exchange = exchange;
	}

	@Override
	public int compareTo(Coin o) {
		return this.price.compareTo(o.price);
	}

	public double getCoinPrice() {
		return this.price;
	}
	
	public Exchanges getExchangeName() {
		return this.exchange;
	}
	
	public Currency getCurrencyName() {
		return this.currency;
	}
}
