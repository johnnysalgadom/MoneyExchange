package com.bcp.challenge.moneyexchange.validators;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.repositories.JpaRoleRepository;
import com.bcp.challenge.moneyexchange.domain.JpaRole;

@Service
public class RoleValidator extends ValidatorTemplate<JpaRole> {

    private final JpaRoleRepository repository;

    public RoleValidator(JpaRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(JpaRole entity) {
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
