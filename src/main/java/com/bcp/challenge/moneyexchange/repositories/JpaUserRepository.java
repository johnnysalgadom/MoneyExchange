package com.bcp.challenge.moneyexchange.repositories;

import com.bcp.challenge.moneyexchange.domain.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<JpaUser, Long>{

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
	
	JpaUser findByUsername(String username);

}
