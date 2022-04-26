package com.bcp.challenge.moneyexchange.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.domain.JpaCurrency;
import com.bcp.challenge.moneyexchange.model.Currency;
import com.bcp.challenge.moneyexchange.services.CurrencyService;
import com.bcp.challenge.moneyexchange.services.impl.CurrencyServiceImpl;

@CrossOrigin
@RequestMapping("/api/currency")
@RestController
public class CurrencyController extends GenericController<CurrencyServiceImpl, JpaCurrency, Currency> {

    private CurrencyService service;

    public CurrencyController(CurrencyServiceImpl service) {
        super(service, new Currency());
        this.service = service;
    }

}
