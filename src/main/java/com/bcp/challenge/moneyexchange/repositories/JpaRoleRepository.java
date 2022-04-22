package com.bcp.challenge.moneyexchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bcp.challenge.moneyexchange.domain.JpaRole;

public interface JpaRoleRepository extends JpaRepository<JpaRole, Long>{

	JpaRole findFirstByDescription(String description);

}
