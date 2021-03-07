package com.crypto.arbitrage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crypto.arbitrage.common.Currency;
import com.crypto.arbitrage.common.Exchanges;
import com.crypto.arbitrage.model.Coin;
import com.crypto.arbitrage.model.CryptoCurrencyExchange;

@Component("CryptoService")
public class CryptoService {
	List<CryptoCurrencyExchange> exchangeList = new ArrayList<>();

	public CryptoService() {
		for(Exchanges e: Exchanges.values()) {
			CryptoCurrencyExchange cryptoCurrencyExchange = new CryptoCurrencyExchange(e);
			exchangeList.add(cryptoCurrencyExchange);
		}
	}

	public Coin getMin(Currency currency) {
		Coin minCoin = exchangeList.get(0).getCoin(currency);
		for(int i = 1;i<exchangeList.size();i++) {
			if(minCoin.getCoinPrice()>exchangeList.get(i).getCoin(currency).getCoinPrice()) {
				minCoin = exchangeList.get(i).getCoin(currency);
			}
		}

		return minCoin;
	}	

	public Coin getMax(Currency currency) {
		Coin maxCoin = exchangeList.get(0).getCoin(currency);
		for(int i = 1;i<exchangeList.size();i++) {
			if(maxCoin.getCoinPrice()<exchangeList.get(i).getCoin(currency).getCoinPrice()) {
				maxCoin = exchangeList.get(i).getCoin(currency);
			}
		}

		return maxCoin;
	}

	public String getArbitrage() {
		StringBuilder rows = new StringBuilder();
		for(Currency currency: Currency.values()) {
			Coin min = this.getMin(currency);
			Coin max = this.getMax(currency);
			rows.append("<tr>")
			.append("<td>")
			.append(currency.name())
			.append("</td>")
			.append("<td>")
			.append(min.getExchangeName()).append("<br />")
			.append("price: $").append(min.getCoinPrice())
			.append("</td>")
			.append("<td>")
			.append(max.getExchangeName()).append("<br />")
			.append("price: $").append(max.getCoinPrice())
			.append("</td>")
			.append("<td>")
			.append(((max.getCoinPrice()-min.getCoinPrice())/min.getCoinPrice())*100)
			.append("</td>")
			.append("</tr>");
		}
		
		return rows.toString();
	}
	
	public String getValues() {
		StringBuilder rows = new StringBuilder();
		rows.append("<table>")
		.append("<tr>")
		.append("<td>").append("<b>Exchange Name</b>").append("</td>")
		.append("<td>").append("<b>Bitcoin</b>").append("</td>")
		.append("<td>").append("<b>Ethereum</b>").append("</td>")
		.append("<td>").append("<b>Cardano</b>").append("</td>")
		.append("<td>").append("<b>Litecoin</b>").append("</td>")
		.append("<td>").append("<b>Bitcoin Cash</b>").append("</td>")
		.append("</tr>");
		for(CryptoCurrencyExchange exchanges: exchangeList) {
			rows.append("<tr>")
			.append("<td>").append(exchanges.getExchangeName().name()).append("</td>")
			.append("<td>").append("$").append(exchanges.getCoin(Currency.BITCOIN).getCoinPrice()).append("</td>")
			.append("<td>").append("$").append(exchanges.getCoin(Currency.ETHEREUM).getCoinPrice()).append("</td>")
			.append("<td>").append("$").append(exchanges.getCoin(Currency.CARDANO).getCoinPrice()).append("</td>")
			.append("<td>").append("$").append(exchanges.getCoin(Currency.LITECOIN).getCoinPrice()).append("</td>")
			.append("<td>").append("$").append(exchanges.getCoin(Currency.BITCOIN_CASH).getCoinPrice()).append("</td>")
			.append("</tr>");
		}
		
		rows.append("</table>");
		
		return rows.toString();

	}
}
