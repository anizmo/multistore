package com.anizmocreations.multistore.controller;

import com.anizmocreations.multistore.requests.LoginRequest;
import com.anizmocreations.multistore.service.LoginService;
import com.anizmocreations.multistore.tables.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ComponentScan(basePackages = "com.anizmocreations")
@Component
@RestController
@RequestMapping(path = "/login")
public class LoginController {

  @Autowired
  private LoginService loginService;

  @PostMapping(value = "/username")
  @ResponseStatus(HttpStatus.OK)
  public User loginByUsername(@RequestBody LoginRequest loginRequest) {
    if (loginRequest.getUsername().isEmpty()
            || loginRequest.getPassword().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and cannot be empty");
    }
    return loginService.getUserFromUsernameLogin(loginRequest);
  }

  @PostMapping(value = "/email")
  @ResponseStatus(HttpStatus.OK)
  public User loginByEmail(@RequestBody LoginRequest loginRequest) {
    if (loginRequest.getEmail().isEmpty()
            || loginRequest.getPassword().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
              "Username and Password cannot be empty");
    }
    return loginService.getUserFromUsernameLogin(loginRequest);
  }

  @PostMapping(value = "/register")
  @ResponseStatus(HttpStatus.OK)
  public User registerUser(@RequestBody LoginRequest userRegistrationRequest) {
    if (userRegistrationRequest.getUsername().isEmpty()
            || userRegistrationRequest.getEmail().isEmpty()
            || userRegistrationRequest.getPassword().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
              "Username, Email and Password cannot be empty");
    }
    return loginService.createUser(userRegistrationRequest);
  }

}
