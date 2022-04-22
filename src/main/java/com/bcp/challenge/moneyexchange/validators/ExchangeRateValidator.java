package com.bcp.challenge.moneyexchange.validators;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.repositories.JpaExchangeRateRepository;

@Service
public class ExchangeRateValidator extends ValidatorTemplate<JpaExchangeRate>{

    private final JpaExchangeRateRepository repository;

    public ExchangeRateValidator(JpaExchangeRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(JpaExchangeRate entity) {
        BadRequestException badRequestException = new BadRequestException();

        if (entity.getCurrency() == null) {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("currency");
            badRequestException.addError(responseError);
        }

        if (entity.getExchangeDate() == null) {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("date");
            badRequestException.addError(responseError);
        }

        if (entity.getSaleValue() == 0) {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("sale value");
            badRequestException.addError(responseError);
        }

        if (entity.getPurchaseValue() == 0) {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("purchase value");
            badRequestException.addError(responseError);
        }

        if (badRequestException.hasErrors()) {
            throw badRequestException;
        }

    }

}
