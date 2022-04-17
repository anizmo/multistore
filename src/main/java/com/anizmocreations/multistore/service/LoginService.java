package com.anizmocreations.multistore.service;

import com.anizmocreations.multistore.requests.LoginRequest;
import com.anizmocreations.multistore.tables.User;
import com.anizmocreations.multistore.repository.LoginRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@ComponentScan(basePackages = "com.anizmocreations")
@Service
public class LoginService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  LoginRepo loginRepo;

  public User getUserFromUsernameLogin(LoginRequest loginRequest) {
//    List<User> usersFromJDBC = jdbcTemplate.query("Select * from users", (rs, rowNum) -> {
//      User user = new User();
//      user.setUserId(rs.getInt(1));
//      user.setUsername(rs.getString(2));
//      user.setPassword(rs.getString(3));
//      user.setEmail(rs.getString(4));
//      return user;
//    });

//    System.out.println(usersFromJDBC);

    final ArrayList<User> users = new ArrayList<>();
    boolean usernameFound = false;

    User dbUser = loginRepo.findByUsername(loginRequest.getUsername());

    if (dbUser.getUsername().equals(loginRequest.getUsername())) {
      usernameFound = true;
      if (dbUser.getPassword().equals(hashPassword(loginRequest.getPassword(),
              dbUser.getCreatedTime().toInstant().toEpochMilli()))) {
        users.add(dbUser);
      }
    }

    if (users.size() > 0) {
      return users.get(0);
    }

    if (usernameFound) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Incorrect Password");
    } else {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Username does not exist");
    }
  }

  public User createUser(LoginRequest userRegisterRequest) {

    if (userRegisterRequest.getUsername() == null || userRegisterRequest.getEmail() == null
            || userRegisterRequest.getPhoneNumber() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
              "Username, Email, and Phone Number are mandatory fields");
    }

    if (checkIfUsernameExistsInDB(userRegisterRequest.getUsername())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT,
              "Username already exists. Try logging in instead.");
    }

    if (checkIfEmailExistsInDB(userRegisterRequest.getEmail())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Email ID already exists");
    }

    if (checkIfPhoneNumberExistsInDB(userRegisterRequest.getEmail())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone Number already exists");
    }

    User user = new User();

    long epochTimeStamp = Instant.now().toEpochMilli();

    Timestamp createdTime = Timestamp.from(Instant.ofEpochSecond(epochTimeStamp));

    user.setUsername(userRegisterRequest.getUsername());
    user.setEmail(userRegisterRequest.getEmail());
    user.setPassword(hashPassword(userRegisterRequest.getPassword(), epochTimeStamp));
    user.setCreatedTime(createdTime);
    user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
    return loginRepo.save(user);
  }

  private boolean checkIfUsernameExistsInDB(String username) {
    User user = loginRepo.findByUsername(username);
    return user != null;
  }

  private boolean checkIfEmailExistsInDB(String email) {
    User user = loginRepo.findByEmail(email);
    return user != null;
  }

  private boolean checkIfPhoneNumberExistsInDB(String phoneNumber) {
    User user = loginRepo.findByPhoneNumber(phoneNumber);
    return user != null;
  }

  private String hashPassword(String password, Long createdTime) {
    return String.valueOf((password).hashCode());
  }

}
