package com.luxoft.cantor.repository.impl;

import java.util.Date;
import java.util.List;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;
import com.luxoft.cantor.util.HibernateUtil;

public class DataBaseCurrencyRepository implements CurrencyRepository {

    @Override
    public List<Dibs> getAllCurrency() {  
        return null;
    }

    @Override
    public Dibs getCurrencyByCode(String code) {
        return null;
    }

    @Override
    public void addNewCurrency(Dibs dibs) {
    	HibernateUtil.sendToDataBase(dibs);
    }

    @Override
    public void deleteCurrencyByCode(String code) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteRateByData(Date date) {
        // TODO Auto-generated method stub

    }

}
