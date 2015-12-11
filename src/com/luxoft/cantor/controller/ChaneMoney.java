package com.luxoft.cantor.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.support.GettingLonelyValueFromPage;

@Controller
public class ChaneMoney {
    @Autowired
    private GettingLonelyValueFromPage blank;
    @Autowired
    private CurrencyRepository currencyRepository;
    private String currenyCode;
    private BigDecimal afterChange = null;
    
    private BigDecimal parsingProtectionAgainstOccurrenceException(DecimalFormat decimalFormat,
    															   String toConvert) {
    	BigDecimal toReturn = new BigDecimal(0.00);
    	
    	try {
			toReturn = (BigDecimal) decimalFormat.parse(toConvert);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	return toReturn;
    }
    
    private BigDecimal convertStringToDigitsDot2Digits(String toConvert) {
    	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    	symbols.setDecimalSeparator('.');
    	String pattern = "#,##0.0#";
    	DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
    	decimalFormat.setParseBigDecimal(true);

    	return parsingProtectionAgainstOccurrenceException(decimalFormat, toConvert);
    }
    
    @RequestMapping(value = "exchange/{currenyCode}",
    				method = RequestMethod.POST)
    public String showAmountAfterChange(@ModelAttribute("encodeHermit") @Valid GettingLonelyValueFromPage blank,
    									BindingResult result,
    									Model model) {
    	if (result.hasErrors()) {
    		return "exchange/currency";  
    	}

    	BigDecimal toChange = convertStringToDigitsDot2Digits(blank.getHermit());
		BigDecimal priceChange = currencyRepository.getCurrencyByCode(currenyCode)
        										   .getDibsRate();
        afterChange = toChange.multiply(priceChange);

        return "redirect:/thanks/resultAndThanks";
    }
    
    @RequestMapping(value = "thanks/resultAndThanks",
    				method = RequestMethod.POST) 
    public String backToMainPage() {
        return "redirect:/";
    }
    
    @RequestMapping(value = "thanks/resultAndThanks",
    				method = RequestMethod.GET) 
    public String showPageWitchExchangeResultAndThanks(Model model) {
        model.addAttribute("afterChange", afterChange);
        
        return "thanks/resultAndThanks";
    }

    @RequestMapping(value = "/exchange/{currenyCode}",
    				method = RequestMethod.GET)
    public String currencyExchangeView(@PathVariable ("currenyCode") String currenyCode,
    								   Model model) {
        if ("manage currencies".equals(currenyCode)) {
            return "redirect:/forms/menageForm";
        }
        
        model.addAttribute("encodeHermit", blank);
        model.addAttribute("currencCode", currenyCode.substring(7));
        
        this.currenyCode = currenyCode.substring(7);
        
        return "exchange/currency";
    }
    
}