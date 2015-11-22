package com.luxoft.cantor.repository;

import java.util.List;

public interface CurrencyRepository {
    List<Dibs> getAllCurrency();
    Dibs getCurrencyByCode(String code);
}
