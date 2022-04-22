package com.bcp.challenge.moneyexchange.services.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.bcp.challenge.moneyexchange.domain.JpaCurrency;
import com.bcp.challenge.moneyexchange.repositories.JpaCurrencyRepository;
import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.services.CurrencyService;
import com.bcp.challenge.moneyexchange.validators.CurrencyValidator;

@Service
public class CurrencyServiceImpl extends GenericService<JpaCurrency, JpaCurrencyRepository, CurrencyValidator> implements CurrencyService {

    public CurrencyServiceImpl(JpaCurrencyRepository repository, CurrencyValidator currencyValidator) {
        super(repository, currencyValidator);
    }

    @Override
    @Transactional
    public JpaCurrency create(JpaCurrency currency) {
        currency = super.create(currency);

        return currency;
    }

}
