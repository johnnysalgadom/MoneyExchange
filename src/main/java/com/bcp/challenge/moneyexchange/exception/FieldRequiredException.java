package com.bcp.challenge.moneyexchange.exception;

import com.bcp.challenge.moneyexchange.model.ResponseError;
import java.util.List;

public class FieldRequiredException  extends RuntimeException {
    public List<ResponseError> responseError;

    public FieldRequiredException(List<ResponseError> responseError) {
        this.responseError = responseError;
    }

    public List<ResponseError> getResponseError() {
        return responseError;
    }

    public void setResponseError(List<ResponseError> responseError) {
        this.responseError = responseError;
    }
}
