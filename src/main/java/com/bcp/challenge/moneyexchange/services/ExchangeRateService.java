package com.bcp.challenge.moneyexchange.services;

import java.util.Date;
import java.util.List;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;

public interface ExchangeRateService {

	List<JpaExchangeRate> getByExchangeDate(Date date);

}
