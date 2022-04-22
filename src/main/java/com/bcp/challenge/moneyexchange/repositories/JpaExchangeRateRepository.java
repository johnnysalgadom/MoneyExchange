package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExchangeRateRepository extends JpaRepository<JpaExchangeRate, Long> {

}
