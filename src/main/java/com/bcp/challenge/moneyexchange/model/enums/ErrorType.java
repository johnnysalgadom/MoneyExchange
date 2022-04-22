package com.bcp.challenge.moneyexchange.model.enums;

public enum ErrorType {
    VALUE_MISSING("value_error.missing"),
    VALUE_REPEATED("value_error.repeated"),
    VALUE_MALFORMED("value_error.malformed");

    private String value;

    ErrorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
