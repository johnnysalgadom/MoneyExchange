package com.bcp.challenge.moneyexchange.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.domain.JpaUser;
import com.bcp.challenge.moneyexchange.repositories.JpaExchangeRepository;
import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.services.ExchangeService;
import com.bcp.challenge.moneyexchange.validators.ExchangeValidator;

@Service
public class ExchangeServiceImpl extends GenericService<JpaExchange, JpaExchangeRepository, ExchangeValidator> implements ExchangeService {

	private JpaExchangeRepository exchangeRepository;
	
	public ExchangeServiceImpl(JpaExchangeRepository repository, ExchangeValidator exchangeValidator) {
        super(repository, exchangeValidator);
        this.exchangeRepository = repository; 
    }

    @Override
    @Transactional
    public JpaExchange create(JpaExchange exchange) {
        exchange = super.create(exchange);

        return exchange;
    }

	@Override
	public List<JpaExchange> getByUser(JpaUser user) {
		List<JpaExchange> exchanges = exchangeRepository.getByUser(user);
		return exchanges;
	}

}
