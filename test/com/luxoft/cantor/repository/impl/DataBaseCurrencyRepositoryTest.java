package com.luxoft.cantor.repository.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.luxoft.cantor.repository.Dibs;
import com.luxoft.cantor.util.CurrencyDAO;

@RunWith(MockitoJUnitRunner.class)
public class DataBaseCurrencyRepositoryTest {
	@Mock
	private CurrencyDAO currencyDao;

	@InjectMocks
	private DataBaseCurrencyRepository currencyRepository = new DataBaseCurrencyRepository();
	private Dibs fakeDibs = new Dibs.BuildDibs()
            .addCode("qwe")
            .addName("ASD")
            .addRate("2")
            .build();
	
    @Test
    public void shouldReturnListWithOneElementForGetAllCurrency() {
        Mockito.when(currencyDao.findAll())
        	   .thenReturn(Arrays.asList(fakeDibs));
        
        assertEquals(1, currencyRepository.getAllCurrency().size());
    }

    @Test
    public void shouldReturnFakeDibsAsExpectedForGetCurrencyByCode() {
    	Mockito.when(currencyDao.findById(Mockito.anyString()))
    		   .thenReturn(fakeDibs);
    	
    	assertEquals(fakeDibs, currencyRepository.getCurrencyByCode("qwe"));
    }
}
