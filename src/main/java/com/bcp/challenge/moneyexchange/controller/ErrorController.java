package com.bcp.challenge.moneyexchange.controller;

import com.bcp.challenge.moneyexchange.exception.BadRequestException;
import com.bcp.challenge.moneyexchange.exception.EntityNotFoundException;
import com.bcp.challenge.moneyexchange.exception.FieldRequiredException;
import com.bcp.challenge.moneyexchange.model.Response;
import com.bcp.challenge.moneyexchange.model.ResponseError;
import com.bcp.challenge.moneyexchange.model.enums.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;

@ControllerAdvice
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Response> entityNotFoundExceptionHandler(RuntimeException exception) {
        logger.error(exception.getMessage());
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setErrors(new ArrayList<>());
        response.setStatus(null);
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Response> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        logger.error(exception.getMessage());
        Response response = new Response();
        ResponseError responseError = new ResponseError();
        responseError.setType(ErrorType.VALUE_MALFORMED);
        ConstraintViolation constraintViolation = exception.getConstraintViolations().iterator().next();
        responseError.setMsg(constraintViolation.getMessageTemplate());
        responseError.setLoc(Arrays.asList("body", constraintViolation.getPropertyPath().toString()));

        response.setMessage("Validation Failed");
        response.setErrors(Arrays.asList(responseError));
        response.setStatus(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> generalExceptionHandler(RuntimeException exception) {
        exception.printStackTrace();
        logger.error(exception.getMessage());
        Response response = new Response();
        response.setMessage("An error occurred processing your request.");
        response.setErrors(new ArrayList<>());
        response.setStatus(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = FieldRequiredException.class)
    public ResponseEntity<Response> fieldRequiredExceptionHandler(FieldRequiredException exception) {
        logger.error(exception.getMessage());
        Response response = new Response();
        response.setMessage("Validation Failed");
        response.setErrors(exception.getResponseError());
        response.setStatus(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Response> badRequestExceptionHandler(BadRequestException exception) {
        logger.error(exception.getMessage());
        Response response = new Response();
        response.setMessage("Validation Failed");
        response.setErrors(exception.getResponseError());
        response.setStatus(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
