package com.luxoft.cantor.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;

@Controller
public class ChaneMoney {
    @Autowired
    private Blank blank;
    @Autowired
    private CurrencyRepository currencyRepository;
    private String currencCode;
    BigDecimal afterChange = null;
    
    @RequestMapping(value = "exchange/{currencCode}", method = RequestMethod.POST)
    public String showAmountAfterChange(@ModelAttribute("enteredAmount") Blank blank, Model model) {
        BigDecimal toChange = new BigDecimal(Integer.parseInt(blank.getAmount()));
        BigDecimal priceChange = currencyRepository.getCurrencyByCode(currencCode).getDibsRate();
        afterChange = toChange.multiply(priceChange);

        return "redirect:/thanks/resultAndThanks";
    }
    
    @RequestMapping(value = "thanks/resultAndThanks", method = RequestMethod.POST) 
    public String backToMainPage() {
        return "redirect:/";
    }
    
    @RequestMapping(value = "thanks/resultAndThanks", method = RequestMethod.GET) 
    public String showPageWitchExchangeResultAndThanks(Model model) {
        model.addAttribute("afterChange", afterChange);
        
        return "thanks/resultAndThanks";
    }

    @RequestMapping(value = "/exchange/{currencCode}", method = RequestMethod.GET)
    public String currencyExchangeView(@PathVariable ("currencCode") String currencCode, Model model) {
        model.addAttribute("enteredAmount", blank);
        model.addAttribute("currencCode", currencCode);
        this.currencCode = currencCode;
        
        return "exchange/currency";
    }
    
}
