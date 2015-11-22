package com.luxoft.cantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;

@Controller
public class MenageMainView {
    @Autowired
    CurrencyRepository currencyRepository;
    
    @RequestMapping(value = "forms/menageForm", method = RequestMethod.GET) 
    public String showPageWitchRegistedCurrenciesAndActionButtons(Model model) {
        model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
        return "forms/menageForm";
    }
}
