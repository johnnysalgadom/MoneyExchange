package com.bcp.challenge.moneyexchange.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.model.Exchange;
import com.bcp.challenge.moneyexchange.services.ExchangeService;
import com.bcp.challenge.moneyexchange.services.impl.ExchangeServiceImpl;

@CrossOrigin
@RequestMapping("exchange")
@RestController
public class ExchangeController extends GenericController<ExchangeServiceImpl, JpaExchange, Exchange> {

    private ExchangeService service;

    public ExchangeController(ExchangeServiceImpl service) {
        super(service, new Exchange());
        this.service = service;
    }

}