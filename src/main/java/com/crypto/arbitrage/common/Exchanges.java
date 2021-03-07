package com.crypto.arbitrage.common;

public enum Exchanges {
	BINANCE("binance"),
	KUCOIN("kucoin"),
	HUOBI_GLOBAL("huobi-global"),
	KRAKEN("kraken"),
	BITTREX("bittrex");
	
	String exchanegName;
	Exchanges(String name) {
		this.exchanegName = name;
	}
	
	public static Exchanges getInstance(String exchangeName) {
		return valueOf(exchangeName);
	}
	
	public String getName() {
		return exchanegName;
	}
}
