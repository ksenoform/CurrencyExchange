package com.luxoft.cantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.luxoft.cantor.repository.CurrencyRepository;

@Controller
public class RatesFormView {
	  @Autowired
	    private CurrencyRepository currencyRepository;

	  
}
