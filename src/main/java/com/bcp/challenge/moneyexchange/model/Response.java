package com.bcp.challenge.moneyexchange.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<MODEL extends GenericModel> {

    private Long id;
    private String status = "Success";
    private String message;
    private List<MODEL> models;
    private List<ResponseError> errors;

    public Response(){};

    public Response(List<MODEL> models){
        this.models = models;
    };

    public Response(Long id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    };

    public Response(Long id, String message) {
        this.id = id;
        this.message = message;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MODEL> getModels() {
        return models;
    }

    public void setModels(List<MODEL> models) {
        this.models = models;
    }

    public List<ResponseError> getErrors() {
        return errors;
    }

    public void setErrors(List<ResponseError> errors) {
        this.errors = errors;
    }
}
