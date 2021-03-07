package com.crypto.arbitrage.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.crypto.arbitrage.common.Currency;
import com.crypto.arbitrage.common.Exchanges;
import com.crypto.arbitrage.common.ParserKeys;
import com.crypto.arbitrage.common.WebCrawler;

public class CryptoCurrencyExchange {
	Exchanges exchangeName;
	Map<Currency, Coin> coinMap = new HashMap<>();
	String baseUrl = "https://coinmarketcap.com/exchanges";
	
	public CryptoCurrencyExchange(Exchanges exchangeName) {
		this.exchangeName = exchangeName;
		init();
	}
	
	private void init() {
		try {
			String url = baseUrl+"/"+exchangeName.getName();
			Elements rows = WebCrawler.fetchAndGetRows(url);
			rows.remove(0);
			List<Element> filteredRows = rows.stream()
					.filter(row-> "spot".equalsIgnoreCase(row.getElementsByClass(ParserKeys.Category.key).tagName("div").text()))
					.filter(row-> Currency.contains(row.getElementsByClass(ParserKeys.Currency.key).tagName("div").text()))
					.filter(row->row.getElementsByClass(ParserKeys.Pair.key).tagName("div").text().contains("USDT"))
					.collect(Collectors.toList());
			prepareMap(filteredRows);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void prepareMap(List<Element> filteredRows) {
		for(Element row:filteredRows) {
			String price = row.getElementsByClass(ParserKeys.Price.key).tagName("div").text();
			Currency currecny = Currency.getInstance(row.getElementsByClass(ParserKeys.Currency.key).tagName("div").text());
			coinMap.put(Currency.getInstance(row.getElementsByClass(ParserKeys.Currency.key).tagName("div").text())
					, new Coin(price, currecny, exchangeName));
		}
	}
	
	public Coin getCoin(Currency currency) {
		return coinMap.get(currency);
	}
	
	public Exchanges getExchangeName() {
		return this.exchangeName;
	}
}
