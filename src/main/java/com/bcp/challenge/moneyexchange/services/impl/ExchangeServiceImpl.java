package com.bcp.challenge.moneyexchange.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.repositories.JpaExchangeRepository;
import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.services.ExchangeService;
import com.bcp.challenge.moneyexchange.validators.ExchangeValidator;

@Service
public class ExchangeServiceImpl extends GenericService<JpaExchange, JpaExchangeRepository, ExchangeValidator> implements ExchangeService {

    public ExchangeServiceImpl(JpaExchangeRepository repository, ExchangeValidator exchangeValidator) {
        super(repository, exchangeValidator);
    }

    @Override
    @Transactional
    public JpaExchange create(JpaExchange exchange) {
        exchange = super.create(exchange);

        return exchange;
    }

}
