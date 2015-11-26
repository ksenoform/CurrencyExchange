package com.luxoft.cantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;
import com.luxoft.cantor.support.Getting3TextValuesFromPage;
import com.luxoft.cantor.support.GettingLonelyWalueFromPage;

@Controller
public class MenageMainView {
    @Autowired
    CurrencyRepository currencyRepository;
    
    @RequestMapping(value = "forms/menageForm", method = RequestMethod.GET) 
    public String showPageWitchRegistedCurrenciesAndActionButtons(Model model) {
        model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
        return "forms/menageForm";
    }
    
    @RequestMapping(value = "addCurrenciesForm", method = RequestMethod.GET) 
    public String showPageWitchFormWhoAllowsAddNewCurrency(Model model) {
        model.addAttribute("currenciesAdd", new Getting3TextValuesFromPage());
        return "addCurrenciesForm";
    }
    
    @RequestMapping(value = "forms/menageForm", params = "Add currencies", method = RequestMethod.POST)
    public String sendingToPageWitchFormWhoAllowsAddNewCurrency(Model model) {
        model.addAttribute("currenciesAdd", new Getting3TextValuesFromPage());
        return "forms/addCurrenciesForm";
    }
    
    @RequestMapping(value = "forms/deleteForm", method = RequestMethod.GET) 
    public String showPageWitchFormWhoShowsDelatingCurrency(Model model) {
        model.addAttribute("currenciesName", new GettingLonelyWalueFromPage());
        return "forms/deleteForm";
    }
    
    @RequestMapping(value = "forms/menageForm", params = "Delete currencies", method = RequestMethod.POST)
    public String sendingToPageWitchFormWhoShowsDelatingCurrency(Model model) {
        model.addAttribute("currenciesName", new GettingLonelyWalueFromPage());
        return "forms/deleteForm";
    }

    @RequestMapping(value = "forms/AfterMenageForm", params = "Main Page", method = RequestMethod.POST) 
    public String backToMainPage() {
    	return "redirect:/";
    }
    
    @RequestMapping(value = "forms/AfterMenageForm", params = "deleteOK", method = RequestMethod.POST) 
    public String backToMainPageAfterDelating(@ModelAttribute ("hermit") String hermit) {
    	currencyRepository.deleteCurrencyByCode(hermit);
    	return "redirect:/";
    }
    
    @RequestMapping(value = "forms/AfterMenageForm", params = "currenciesAddOK", method = RequestMethod.POST) 
    public String backToMainPageAfterMenageForm(@ModelAttribute ("currenciesAdd") Getting3TextValuesFromPage fromPage) {
    	currencyRepository.addNewCurrency(new Dibs.BuildDibs()
    											  .addCode(fromPage.getCode())
    											  .addName(fromPage.getName())
    											  .addRate(fromPage.getValue())
    											  .build());
    	return "redirect:/";
    }
    
    @RequestMapping(value = "forms/menageForm", params = "Rates", method = RequestMethod.POST)
    public String sendingToPageWitchRatesForm(Model model) {
    	model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
    	return "forms/ratesForm";
    }
}
