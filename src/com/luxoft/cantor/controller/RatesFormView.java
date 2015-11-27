package com.luxoft.cantor.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@RequestMapping(value = "forms")
public class RatesFormView {
	@Autowired
	private CurrencyRepository currencyRepository;

	@RequestMapping(value = "ofFormToMenagment", params = "Currencies", method = RequestMethod.GET)
	public String showPageWitchRatesForm(Model model) {
		return "forms/menageChosenCurrency";
	}

	@RequestMapping(value = "ofFormToMenagment", params = "Currencies", method = RequestMethod.POST)
	public String getFromPageWitchRatesForm(@ModelAttribute("currenc") GettingLonelyWalueFromPage currenc,
			Model model) {
		model.addAttribute("currentCode", currencyRepository.getCurrencyByCode(currenc.getHermit()));
		model.addAttribute("currenc", new GettingLonelyWalueFromPage());
		return "forms/menageChosenCurrency";
	}

	@RequestMapping(value = "ofFormOneCurrency", params = "Delete Rate", method = RequestMethod.POST)
	public String recivingDelateRequestFromRatesForm(@ModelAttribute("currenc") GettingLonelyWalueFromPage currenc,
			Model model) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy:HH:mm:SS");
		Date convertedDate = null;
		try {
			convertedDate = (Date) formatter.parse(currenc.getHermit());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		currencyRepository.deleteRateByData(convertedDate);
		return "forms/menageChosenCurrency";
	}

	@RequestMapping(value = "menageForm", params = "Rates", method = RequestMethod.POST)
	public String sendingToPageWitchRatesForm(Model model) {
		model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
		model.addAttribute("currenc", new GettingLonelyWalueFromPage());
		return "forms/ratesForm";
	}

	@RequestMapping(value = "menageForm", method = RequestMethod.GET)
	public String showPageWitchRegistedCurrenciesAndActionButtons(Model model) {
		model.addAttribute("currencyRates", currencyRepository.getAllCurrency());
		return "forms/menageForm";
	}

	@RequestMapping(value = "menageForm", params = "Add currencies", method = RequestMethod.POST)
	public String sendingToPageWitchFormWhoAllowsAddNewCurrency(Model model) {
		model.addAttribute("currenciesAdd", new Getting3TextValuesFromPage());
		return "forms/addCurrenciesForm";
	}

	@RequestMapping(value = "deleteForm", method = RequestMethod.GET)
	public String showPageWitchFormWhoShowsDelatingCurrency(Model model) {
		model.addAttribute("currenciesName", new GettingLonelyWalueFromPage());
		return "forms/deleteForm";
	}

	@RequestMapping(value = "menageForm", params = "Delete currencies", method = RequestMethod.POST)
	public String sendingToPageWitchFormWhoShowsDelatingCurrency(Model model) {
		model.addAttribute("currenciesName", new GettingLonelyWalueFromPage());
		return "forms/deleteForm";
	}

	@RequestMapping(value = "AfterMenageForm", params = "Main Page", method = RequestMethod.POST)
	public String backToMainPage() {
		return "redirect:/";
	}

	@RequestMapping(value = "AfterMenageForm", params = "deleteOK", method = RequestMethod.POST)
	public String backToMainPageAfterDelating(@ModelAttribute("hermit") String hermit) {
		currencyRepository.deleteCurrencyByCode(hermit);
		return "redirect:/";
	}

	@RequestMapping(value = "AfterMenageForm", params = "currenciesAddOK", method = RequestMethod.POST)
	public String backToMainPageAfterMenageForm(@ModelAttribute("currenciesAdd") Getting3TextValuesFromPage fromPage) {
		currencyRepository.addNewCurrency(new Dibs.BuildDibs().addCode(fromPage.getCode()).addName(fromPage.getName())
				.addRate(fromPage.getValue()).build());
		return "redirect:/";
	}
}
