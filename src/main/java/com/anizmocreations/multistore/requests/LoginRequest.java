package com.anizmocreations.multistore.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

  private String username;

  private String password;

  private String email;

  private String phoneNumber;

}
