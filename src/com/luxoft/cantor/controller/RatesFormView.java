package com.luxoft.cantor.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;
import com.luxoft.cantor.support.Getting3TextValuesFromPage;
import com.luxoft.cantor.support.GettingLonelyValueFromPage;

@Controller
@RequestMapping(value = "forms")
public class RatesFormView {
    @Autowired
    private CurrencyRepository currencyRepository;
    private String currentCode;

    @RequestMapping(value = "ofFormToMenagment",
    				params = "Currencies",
    				method = RequestMethod.GET)
    public String showPageWitchRatesForm(Model model) {
        return "forms/menageChosenCurrency";
    }

    @RequestMapping(value = "ofFormToMenagment",
    				params = "Currencies",
    				method = RequestMethod.POST)
    public String getFromPageWitchRatesForm(@ModelAttribute("currenc") GettingLonelyValueFromPage currenc,
            								Model model) {
        currentCode = currenc.getHermit();
        
        model.addAttribute("currentCode", currencyRepository.getCurrencyByCode(
        														currenc.getHermit()));
        model.addAttribute("currenc", new GettingLonelyValueFromPage());
        
        return "forms/menageChosenCurrency";
    }

    @RequestMapping(value = "ofFormOneCurrency",
    				params = "Delete Rate",
    				method = RequestMethod.POST)
    public String recivingDelateRequestFromRatesForm(@ModelAttribute("currenc") GettingLonelyValueFromPage currenc,
            										 Model model) {
        Dibs processingDibs = currencyRepository.getCurrencyByCode(currentCode);
        
        processingDibs.deleteRateFromList(currenc.getHermit());
        model.addAttribute("currentCode", currencyRepository.getCurrencyByCode(
        														currentCode));
        model.addAttribute("currenc", new GettingLonelyValueFromPage());
        
        return "forms/menageChosenCurrency";
    }

    @RequestMapping(value = "ofFormOneCurrency",
    				params = "Set as Active", 
    				method = RequestMethod.POST)
    public String recivingSetAsActiveRequestFromRatesForm(@ModelAttribute("currenc") GettingLonelyValueFromPage currenc,
            											  Model model) {
        Dibs processingDibs = currencyRepository.getCurrencyByCode(
        											currentCode);
        processingDibs.setActiveRate(currenc.getHermit());

        return "redirect:/";
    }

    @RequestMapping(value = "ofFormOneCurrency",
    				params = "Add Rate",
    				method = RequestMethod.POST)
    public String recivingAddRequestFromRatesForm(@ModelAttribute("currenc") GettingLonelyValueFromPage currenc,
            									  Model model) {
        Dibs processingDibs = currencyRepository.getCurrencyByCode(
        											currentCode);
        processingDibs.setDibsRate(new BigDecimal(
        								currenc.getHermit()));

        return "redirect:/";
    }

    @RequestMapping(value = "menageForm",
    				params = "Rates",
    				method = RequestMethod.POST)
    public String sendingToPageWitchRatesForm(Model model) {
        model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
        model.addAttribute("currenc", new GettingLonelyValueFromPage());
        
        return "forms/ratesForm";
    }

    @RequestMapping(value = "menageForm", 
    				method = RequestMethod.GET)
    public String showPageWitchRegistedCurrenciesAndActionButtons(Model model) {
        model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
        
        return "forms/menageForm";
    }

    @RequestMapping(value = "menageForm", 
    				params = "Add currencies", 
    				method = RequestMethod.POST)
    public String sendingToPageWitchFormWhoAllowsAddNewCurrency(Model model) {
        model.addAttribute("currenciesAdd", new Getting3TextValuesFromPage());
        
        return "forms/addCurrenciesForm";
    }

    @RequestMapping(value = "deleteForm",
    				method = RequestMethod.GET)
    public String showPageWitchFormWhoShowsDelatingCurrency(Model model) {
        model.addAttribute("currenciesName", new GettingLonelyValueFromPage());
        
        return "forms/deleteForm";
    }

    @RequestMapping(value = "menageForm", 
    				params = "Delete currencies", 
    				method = RequestMethod.POST)
    public String sendingToPageWitchFormWhoShowsDelatingCurrency(Model model) {
        model.addAttribute("currenciesName", new GettingLonelyValueFromPage());
        
        return "forms/deleteForm";
    }

    @RequestMapping(value = { "AfterMenageForm", "ofFormOneCurrency" },
    				params = "Main Page",
    				method = RequestMethod.POST)
    public String backToMainPage() {
        return "redirect:/";
    }

    @RequestMapping(value = "AfterMenageForm", 
    				params = "deleteOK",
    				method = RequestMethod.POST)
    public String backToMainPageAfterDelating(@ModelAttribute("hermit") String hermit) {
        currencyRepository.deleteCurrencyByCode(hermit);
       
        return "redirect:/";
    }

    @RequestMapping(value = "AfterMenageForm",
    				params = "currenciesAddOK", 
    				method = RequestMethod.POST)
    public String backToMainPageAfterMenageForm(@ModelAttribute("currenciesAdd") Getting3TextValuesFromPage fromPage) {
        currencyRepository.addNewCurrency(new Dibs.BuildDibs()
        										  .addCode(fromPage.getCode())
        										  .addName(fromPage.getName())
        										  .addRate(fromPage.getValue())
        										  .build());
        
        return "redirect:/";
    }
}
