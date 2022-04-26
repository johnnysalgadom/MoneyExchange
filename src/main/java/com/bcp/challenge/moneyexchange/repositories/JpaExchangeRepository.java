package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import com.bcp.challenge.moneyexchange.domain.JpaUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExchangeRepository extends JpaRepository<JpaExchange, Long> {

	List<JpaExchange> getByUser(JpaUser user);

}
