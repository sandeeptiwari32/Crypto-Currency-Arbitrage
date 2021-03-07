package com.crypto.arbitrage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crypto.arbitrage.service.CryptoService;

@Controller
public class CryptoController {
	
	@Autowired
	@Qualifier("CryptoService")
	private CryptoService cryptoService;

	@RequestMapping("")
	public String getHome(Model model) {
		String rows = cryptoService.getArbitrage();
		String values = cryptoService.getValues();
		model.addAttribute("rows", rows);
		model.addAttribute("values", values);
		return "index";
	}
}
