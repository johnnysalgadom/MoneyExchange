package com.bcp.challenge.moneyexchange.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.domain.JpaUser;
import com.bcp.challenge.moneyexchange.repositories.JpaUserRepository;
import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.services.UserService;
import com.bcp.challenge.moneyexchange.validators.UserValidator;

@Service
public class UserServiceImpl extends GenericService<JpaUser, JpaUserRepository, UserValidator> implements UserService {

    public UserServiceImpl(JpaUserRepository repository, UserValidator userValidator) {
        super(repository, userValidator);
    }

    @Override
    @Transactional
    public JpaUser create(JpaUser user) {
        user = super.create(user);

        return user;
    }

}
