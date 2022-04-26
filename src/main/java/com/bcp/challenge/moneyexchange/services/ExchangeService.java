package com.bcp.challenge.moneyexchange.services;

import java.util.List;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.domain.JpaUser;

public interface ExchangeService {

	List<JpaExchange> getByUser(JpaUser user);

}
