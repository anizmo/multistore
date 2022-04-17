package com.anizmocreations.multistore.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {

  private String storeName;

  private String storeDescription;

  private String storeUsername;

  private String password;

  private String storePhoneNumber;

}
