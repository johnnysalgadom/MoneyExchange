package com.bcp.challenge.moneyexchange.services;

import com.bcp.challenge.moneyexchange.domain.JpaUser;

public interface UserService {

	public JpaUser findByUsername(String username);

}
