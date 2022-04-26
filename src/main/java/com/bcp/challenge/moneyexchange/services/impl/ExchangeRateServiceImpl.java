package com.bcp.challenge.moneyexchange.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import com.bcp.challenge.moneyexchange.repositories.JpaExchangeRateRepository;
import com.bcp.challenge.moneyexchange.services.ExchangeRateService;
import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.validators.ExchangeRateValidator;

@Service
public class ExchangeRateServiceImpl extends GenericService<JpaExchangeRate, JpaExchangeRateRepository, ExchangeRateValidator> implements ExchangeRateService {

	private JpaExchangeRateRepository exchangeRateRepository;
	
    public ExchangeRateServiceImpl(JpaExchangeRateRepository repository, ExchangeRateValidator exchangeRateValidator) {
        super(repository, exchangeRateValidator);
        this.exchangeRateRepository = repository; 
    }

    @Override
    @Transactional
    public JpaExchangeRate create(JpaExchangeRate exchangeRate) {
        exchangeRate = super.create(exchangeRate);
        return exchangeRate;
    }

	@Override
	public List<JpaExchangeRate> getByExchangeDate(Date date) {
		List<JpaExchangeRate> exchangeRate = exchangeRateRepository.getByExchangeDate(date);
		return exchangeRate;
	}

}
