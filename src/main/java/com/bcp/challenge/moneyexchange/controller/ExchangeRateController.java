package com.bcp.challenge.moneyexchange.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import com.bcp.challenge.moneyexchange.model.ExchangeRate;
import com.bcp.challenge.moneyexchange.model.Response;
import com.bcp.challenge.moneyexchange.services.ExchangeRateService;
import com.bcp.challenge.moneyexchange.services.impl.ExchangeRateServiceImpl;

@CrossOrigin
@RequestMapping("/api/exchange-rate")
@RestController
public class ExchangeRateController extends GenericController<ExchangeRateServiceImpl, JpaExchangeRate, ExchangeRate> {

    private ExchangeRateService service;

    public ExchangeRateController(ExchangeRateServiceImpl service) {
        super(service, new ExchangeRate());
        this.service = service;
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<?> getByDate(@PathParam("date") @PathVariable("date") String date){

    	if (date != null && date != "") {

    		ZoneId defaultZoneId = ZoneId.systemDefault();
    		String[] dates = date.split("-");

    		if (dates != null && dates.length > 2) {
	    		LocalDate localDate = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
	    		Date newDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
	            return new ResponseEntity<Response>(new Response(this.service.getByExchangeDate(newDate)), HttpStatus.OK);    		
    		} else {
	    		return new ResponseEntity<>("Fecha errada", HttpStatus.BAD_REQUEST);    			
    		}

    	} else {
    		return new ResponseEntity<>("Fecha errada", HttpStatus.BAD_REQUEST);
    	}

    }
    
}