package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCurrencyRepository extends JpaRepository<JpaCurrency, Long> {

}
