package com.restful.webservices.restfulwebservices.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.restfulwebservices.Exceptions.UserNotCreatedException;
import com.restful.webservices.restfulwebservices.Exceptions.UserNotFoundException;
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

    @GetMapping("/users/{id}")
    public User retrieveOneUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id+" n'existe pas");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        if(user.getName()==null || user.getBirthDate()==null){
            throw new UserNotCreatedException("Bad payload");
        }
        User savedUser = userDaoService.save(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
   
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteOne(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id+" n'existe pas");
        }
    }
}
