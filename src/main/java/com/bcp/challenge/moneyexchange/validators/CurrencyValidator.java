package com.bcp.challenge.moneyexchange.validators;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaCurrency;
import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.repositories.JpaCurrencyRepository;

@Service
public class CurrencyValidator extends ValidatorTemplate<JpaCurrency> {

    private final JpaCurrencyRepository repository;

    public CurrencyValidator(JpaCurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(JpaCurrency entity) {
        BadRequestException badRequestException = new BadRequestException();

        if (entity.getDescription() == "") {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("description");
            badRequestException.addError(responseError);
        }

        if (badRequestException.hasErrors()) {
            throw badRequestException;
        }

    }

}
