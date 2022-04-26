package com.bcp.challenge.moneyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.domain.JpaUser;
import com.bcp.challenge.moneyexchange.model.Exchange;
import com.bcp.challenge.moneyexchange.model.Response;
import com.bcp.challenge.moneyexchange.services.ExchangeService;
import com.bcp.challenge.moneyexchange.services.UserService;
import com.bcp.challenge.moneyexchange.services.impl.ExchangeServiceImpl;

@CrossOrigin
@RequestMapping("/api/exchange")
@RestController
public class ExchangeController extends GenericController<ExchangeServiceImpl, JpaExchange, Exchange> {

    private ExchangeService exchangeService;

    @Autowired
    private UserService userService;

    public ExchangeController(ExchangeServiceImpl service) {
        super(service, new Exchange());
        this.exchangeService = service;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllByUser(){

    	String userDetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("userdetali: " + userDetails);
    	String username = userDetails;
    	
    	JpaUser user = userService.findByUsername(username);
    	
    	if (user != null) {
    		//Long userId = user.getId();
            return new ResponseEntity<Response>(new Response(this.exchangeService.getByUser(user)), HttpStatus.OK);    		
    	} else {
    		return new ResponseEntity<>("Usuario no existe", HttpStatus.BAD_REQUEST);    		
    	}

    }
    
}