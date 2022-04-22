package com.bcp.challenge.moneyexchange.exception;

import com.bcp.challenge.moneyexchange.model.ResponseError;

import java.util.ArrayList;
import java.util.List;

public class BadRequestException extends RuntimeException {
    public List<ResponseError> responseError = new ArrayList<>();

    public BadRequestException(List<ResponseError> responseError) {
        this.responseError = responseError;
    }

    public BadRequestException() {}

    public List<ResponseError> getResponseError() {
        return responseError;
    }

    public void setResponseError(List<ResponseError> responseError) {
        this.responseError = responseError;
    }

    public void addError(ResponseError error) {
        if (responseError==null) {
            responseError = new ArrayList<>();
        }
        responseError.add(error);
    }

    public boolean hasErrors() {
        return responseError!=null && responseError.size()>0;
    }
}
