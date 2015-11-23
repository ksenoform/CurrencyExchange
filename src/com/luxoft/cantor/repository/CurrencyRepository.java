package com.luxoft.cantor.repository;

import java.util.List;
import com.luxoft.cantor.repository.Dibs;

public interface CurrencyRepository {
    public List<Dibs> getAllCurrency();
    public Dibs getCurrencyByCode(String code);
    public void deleteCurrencyByCode(String code);
}
