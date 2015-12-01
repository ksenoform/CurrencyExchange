package com.luxoft.cantor.repository.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.luxoft.cantor.repository.Dibs;

public class DataBaseCurrencyRepositoryTest {

    @Test
    public void testGetCurrencyByCode() {
        DataBaseCurrencyRepository currencyRepository = Mockito.mock(DataBaseCurrencyRepository.class);
        Mockito.when(currencyRepository.getAllCurrency()).thenReturn(Arrays.asList(
              new Dibs.BuildDibs()
              .addCode("qwe")
              .addName("ASD")
              .addRate("2")
              .build()
              ));
//                                     = new DataBaseCurrencyRepository() {
//                                                public List<Dibs> getAllCurrency() {
//                                                         return(new ArrayList<Dibs>(
//                                                                 Arrays.asList(
//                                                                         new Dibs.BuildDibs()
//                                                                         .addCode("qwe")
//                                                                         .addName("ASD")
//                                                                         .addRate("2")
//                                                                         .build()
//                                                                         )));
//                                                }};
        
        Mockito.when(currencyRepository.getCurrencyByCode("qwe")).thenCallRealMethod();
        Dibs toCheck = currencyRepository.getCurrencyByCode("qwe");
        assertEquals("qawe", toCheck.getDibsCode());
    }

}
