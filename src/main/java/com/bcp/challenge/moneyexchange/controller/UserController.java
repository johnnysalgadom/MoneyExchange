package com.bcp.challenge.moneyexchange.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.challenge.moneyexchange.model.User;
import com.bcp.challenge.moneyexchange.services.UserService;
import com.bcp.challenge.moneyexchange.services.impl.UserServiceImpl;
import com.bcp.challenge.moneyexchange.domain.JpaUser;

@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController extends GenericController<UserServiceImpl, JpaUser, User> {

    private UserService service;

    public UserController(UserServiceImpl service) {
        super(service, new User());
        this.service = service;
    }

}
