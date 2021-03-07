package com.crypto.arbitrage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CryptoCurrencyArbitrageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyArbitrageApplication.class, args);
	}

}
