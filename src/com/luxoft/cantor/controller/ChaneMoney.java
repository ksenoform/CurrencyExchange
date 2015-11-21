package com.luxoft.cantor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChaneMoney {
    @RequestMapping(value = "/exchange",params = "currency")
    public String currencyExchangeView() {
        return "exchange/currency";
    }
}
