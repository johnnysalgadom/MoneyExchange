package com.bcp.challenge.moneyexchange.validators;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.repositories.JpaExchangeRepository;

@Service
public class ExchangeValidator extends ValidatorTemplate<JpaExchange> {
    
	private final JpaExchangeRepository repository;

    public ExchangeValidator(JpaExchangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(JpaExchange entity) {
        BadRequestException badRequestException = new BadRequestException();

        if (entity.getUser() == null) {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("user");
            badRequestException.addError(responseError);
        }

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
