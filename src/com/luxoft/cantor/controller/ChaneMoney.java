package com.luxoft.cantor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChaneMoney {
    @RequestMapping(value = "/exchange", params = "currency", method = RequestMethod.GET)
    public String currencyExchangeView(Model model) {
        Blank blank = new Blank();
        model.addAttribute("enteredAmount", blank);
        return "exchange/currency";
    }
    
    @RequestMapping(value = "/exchange", params = "currency", method = RequestMethod.POST)
    public String showAmountAfterChange(@ModelAttribute("enteredAmount") Blank blank) {
        return "exchange/currency";
    }
}
