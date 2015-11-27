package com.luxoft.cantor.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;

@Repository
public class InMemoryCurrencyRepository implements CurrencyRepository {
    private List<Dibs> AllCurrency = new ArrayList<Dibs>();
    
    public InMemoryCurrencyRepository() {
        Dibs eur = new Dibs();
        eur.setDibsCode("EUR");
        eur.setDibsName("euro");
        eur.setDibsRate(new BigDecimal(4.22));
        
        Dibs usd = new Dibs();
        usd.setDibsCode("USD");
        usd.setDibsName("US Dollar");
        usd.setDibsRate(new BigDecimal(3.56));
        
        Dibs jpy = new Dibs();
        jpy.setDibsCode("jpy");
        jpy.setDibsName("Japanese yen");
        jpy.setDibsRate(new BigDecimal(3.12));
        
        AllCurrency.add(eur);
        AllCurrency.add(usd);
        AllCurrency.add(jpy);
    }
    
    @Override
    public List<Dibs> getAllCurrency() {
        return AllCurrency;
    }

    @Override
    public Dibs getCurrencyByCode(String code) {
        Dibs currencyByCode = null;
        
        for(Dibs dibs: AllCurrency) {
            if (dibs.getDibsCode().equals(code)) {
                currencyByCode = dibs;
            }
        }
        
        return currencyByCode;
    }

	@Override
	public void addNewCurrency(Dibs dibs) {
		AllCurrency.add(dibs);
	}
	
    @Override
    public void deleteCurrencyByCode(String code) {
        Dibs dibs = getCurrencyByCode(code);
        AllCurrency.remove(dibs);
    }

	@Override
	public void deleteRateByData(Date date) {
		// TODO Auto-generated method stub
		
	}

}
