package com.bcp.challenge.moneyexchange.validators;

import com.bcp.challenge.moneyexchange.domain.JpaUser;
import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.repositories.JpaUserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserValidator extends ValidatorTemplate<JpaUser> {

    private final JpaUserRepository repository;

    public UserValidator(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(JpaUser entity) {
        BadRequestException badRequestException = new BadRequestException();

        if (entity.getUsername() == "") {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("username");
            badRequestException.addError(responseError);
        }

        if (entity.getPassword() == "") {
            ResponseError responseError = new ResponseError();
            responseError.getLoc().add("body");
            responseError.getLoc().add("password");
            badRequestException.addError(responseError);
        }
        if (badRequestException.hasErrors()) {
            throw badRequestException;
        }

    }
}
