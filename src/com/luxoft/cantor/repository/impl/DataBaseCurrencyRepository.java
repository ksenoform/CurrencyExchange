package com.luxoft.cantor.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.luxoft.cantor.repository.CurrencyRepository;
import com.luxoft.cantor.repository.Dibs;
import com.luxoft.cantor.util.HibernateUtil;

public class DataBaseCurrencyRepository implements CurrencyRepository {

    private Session session;

    @Override
    public List<Dibs> getAllCurrency() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<Dibs> allCurrency = session.createQuery("from DIBS").list();
        
        session.getTransaction().commit();
        
        return allCurrency;
    }

    @Override
    public Dibs getCurrencyByCode(String code) {
    	List<Dibs> allCurrency = getAllCurrency();
    	Dibs dibs = null;
    	
    	for(Dibs oneCurrency: allCurrency) {
    		if (code.equals(oneCurrency.getDibsCode())) {
    			dibs = oneCurrency;
    		}
    	}
    	
        return dibs;
    }

    @Override
    public void addNewCurrency(Dibs dibs) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(dibs);
        session.getTransaction().commit();
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
