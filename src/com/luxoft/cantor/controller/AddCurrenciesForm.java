package com.luxoft.cantor.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;

@Controller
public class AddCurrenciesForm {
	@Autowired
	CurrencyRepository currencyRepository;
	
	@RequestMapping(value="/forms/addCurrenciesForm",
					method = RequestMethod.GET)
	public String showPageForAddCurrenciesForm() {
		return "forms/addCurrenciesForm";
	}
	
	@RequestMapping(value="/forms/afterAddCurrenciesForm",
					params="addCurrencies",
					method = RequestMethod.POST)
	public String getPageForAddCurrenciesForm(@RequestParam ("addCurrencie") String dibsCode,
											  @RequestParam ("addCurrencie") String dibsName,
											  @RequestParam ("addCurrencie") String dibsRate) {
		Dibs dibs = new Dibs();
		dibs.setDibsCode(dibsCode);
		dibs.setDibsName(dibsName);
		dibs.setDibsRate(new BigDecimal(dibsRate));
		currencyRepository.addNewCurrency(dibs);

		return "redirect:/";
	}

}
