package com.luxoft.cantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.support.Getting3TextValuesFromPage;

@Controller
public class MenageMainView {
    @Autowired
    CurrencyRepository currencyRepository;
    
    @RequestMapping(value = "addCurrenciesForm",
    				method = RequestMethod.GET) 
    public String showPageWitchFormWhoAllowsAddNewCurrency(Model model) {
        model.addAttribute("currenciesAdd", new Getting3TextValuesFromPage());
        return "addCurrenciesForm";
    }
   
}
