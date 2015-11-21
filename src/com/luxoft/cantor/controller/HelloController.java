package com.luxoft.cantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luxoft.cantor.repository.CurrencyRepository;

@Controller
public class HelloController {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private Blank blank;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloMessage(Model model) {
        model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
        return "welcome";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String handlePost(@RequestParam(required=false, value="Exchange") String exchange,
                             @RequestParam(required=false, value="Manage currencies") String manageCurrencies,
                             Model model){

        model.addAttribute("enteredAmount", blank);
        if(exchange != null) {
            return "exchange/currency";
        } else {
            return "exchange/currency";
        }

    } 
}
