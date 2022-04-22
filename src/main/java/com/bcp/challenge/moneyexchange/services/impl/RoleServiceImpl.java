package com.bcp.challenge.moneyexchange.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bcp.challenge.moneyexchange.services.GenericService;
import com.bcp.challenge.moneyexchange.services.RoleService;
import com.bcp.challenge.moneyexchange.repositories.JpaRoleRepository;
import com.bcp.challenge.moneyexchange.validators.RoleValidator;
import com.bcp.challenge.moneyexchange.domain.JpaRole;

@Service
public class RoleServiceImpl extends GenericService<JpaRole, JpaRoleRepository, RoleValidator> implements RoleService {

	final JpaRoleRepository roleRepository;
	
    public RoleServiceImpl(JpaRoleRepository repository, RoleValidator roleValidator) {
        super(repository, roleValidator);
        this.roleRepository = repository;
    }

    @Override
    @Transactional
    public JpaRole create(JpaRole role) {

    	role = super.create(role);

        return role;

    }

    
}
