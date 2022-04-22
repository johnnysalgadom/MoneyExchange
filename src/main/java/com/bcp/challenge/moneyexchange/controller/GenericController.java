package com.bcp.challenge.moneyexchange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.Arrays;

import com.bcp.challenge.moneyexchange.domain.BaseEntity;
import com.bcp.challenge.moneyexchange.model.GenericModel;
import com.bcp.challenge.moneyexchange.model.Response;
import com.bcp.challenge.moneyexchange.services.GenericService;

public class GenericController<SERVICE extends GenericService, ENTITY extends BaseEntity, MODEL extends GenericModel<ENTITY>> {

    private final SERVICE service;
    private final MODEL model;

    public GenericController(SERVICE service, MODEL model) {
        this.service = service;
        this.model = model;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Response> create(@RequestBody MODEL model) {
        ENTITY entity = model.toEntity();
        entity = (ENTITY) service.create(entity);

        return new ResponseEntity<Response>(new Response(entity.getId(), "Object successfully created."), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response> retrieve(@PathParam("id") @PathVariable("id") String id) throws Throwable {
        ENTITY entity = (ENTITY) service.retrieve(Long.parseLong(id));
        MODEL model = this.model.fromEntity(entity);

        return new ResponseEntity<Response>(new Response(Arrays.asList(model)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> retrieveAll() {
        return new ResponseEntity<Response>(new Response(service.retrieveAll()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@RequestBody MODEL model,
                                           @PathVariable(required = true) String id) {
        ENTITY entity = model.toEntity();
        entity = (ENTITY) service.update(entity, Long.parseLong(id));

        return new ResponseEntity<Response>(new Response(entity.getId(), "Object successfully updated."), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathParam("id") @PathVariable("id") String id) throws Throwable {
        service.delete(Long.parseLong(id));

        return new ResponseEntity<Response>(new Response(Long.parseLong(id), "Object successfully deleted."), HttpStatus.OK);
    }

}
