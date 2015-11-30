package com.luxoft.cantor.repository.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.luxoft.cantor.repository.Dibs;

public class DataBaseCurrencyRepositoryTest {

    @Test
    public void testGetCurrencyByCode() {
        DataBaseCurrencyRepository currencyRepository
                                     = new DataBaseCurrencyRepository() {
                                                public List<Dibs> getAllCurrency() {
                                                         return(new ArrayList<Dibs>(
                                                                 Arrays.asList(
                                                                         new Dibs.BuildDibs()
                                                                         .addCode("qwe")
                                                                         .addName("ASD")
                                                                         .addRate("2")
                                                                         .build()
                                                                         )));
                                                }};
        
        Dibs toCheck = currencyRepository.getCurrencyByCode("qwe");
        assertEquals("qwe", toCheck.getDibsCode());
    }

}
