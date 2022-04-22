package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExchangeRepository extends JpaRepository<JpaExchange, Long> {

}
