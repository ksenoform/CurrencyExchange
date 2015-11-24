package com.luxoft.cantor.repository;

import java.util.List;

public interface CurrencyRepository {
    public List<Dibs> getAllCurrency();
    public Dibs getCurrencyByCode(String code);
    public void addNewCurrency(Dibs dibs);
}
