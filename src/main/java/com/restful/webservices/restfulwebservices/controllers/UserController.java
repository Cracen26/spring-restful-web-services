package com.restful.webservices.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.restfulwebservices.domains.User.User;
import com.restful.webservices.restfulwebservices.domains.User.UserDaoService;


@RestController()
public class UserController {

    @Autowired
    private UserDaoService userDaoService;



    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }


   
}
