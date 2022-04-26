package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaExchangeRate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExchangeRateRepository extends JpaRepository<JpaExchangeRate, Long> {

	List<JpaExchangeRate> getByExchangeDate(Date date);

}
