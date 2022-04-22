package com.bcp.challenge.moneyexchange.validators;

public abstract class ValidatorTemplate<ENTITY> {

    public abstract void validate(ENTITY entity);

}

