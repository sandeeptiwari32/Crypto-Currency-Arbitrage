package com.crypto.arbitrage.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawler {
	public static Document fetchData(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
	
	public static Elements fetchAndGetRows(String url) throws IOException {
		Document doc = fetchData(url);
		Elements tableEle = doc.getElementsByClass(ParserKeys.Table.key).get(2).getElementsByTag("table");
		return tableEle.tagName("tr").get(0).getElementsByTag("tbody").tagName("tr").get(0).getElementsByTag("tr");
	}
}
