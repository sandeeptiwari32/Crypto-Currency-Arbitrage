package com.crypto.arbitrage.common;

public enum ParserKeys {
	Category("cmc-table__cell cmc-table__cell--sortable cmc-table__cell--right cmc-table__cell--sort-by__category"),
	Currency("cmc-table__cell cmc-table__cell--sticky cmc-table__cell--sortable cmc-table__cell--left cmc-table__cell--sort-by__market-pair-base-currency-name"),
	Price("cmc-table__cell cmc-table__cell--sortable cmc-table__cell--right cmc-table__cell--sort-by__price"),
	Pair("cmc-table__cell cmc-table__cell--sortable cmc-table__cell--left cmc-table__cell--sort-by__market-pair"),
	Table("cmc-table__table-wrapper-outer");

	public String key;
	ParserKeys(String key) {
		this.key = key;
	}
}
