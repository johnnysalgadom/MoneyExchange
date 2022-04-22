package com.bcp.challenge.moneyexchange.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import com.bcp.challenge.moneyexchange.model.ExchangeRate;
import com.bcp.challenge.moneyexchange.services.ExchangeRateService;
import com.bcp.challenge.moneyexchange.services.impl.ExchangeRateServiceImpl;

@CrossOrigin
@RequestMapping("exchange-rate")
@RestController
public class ExchangeRateController extends GenericController<ExchangeRateServiceImpl, JpaExchangeRate, ExchangeRate> {

    private ExchangeRateService service;

    public ExchangeRateController(ExchangeRateServiceImpl service) {
        super(service, new ExchangeRate());
        this.service = service;
    }

}