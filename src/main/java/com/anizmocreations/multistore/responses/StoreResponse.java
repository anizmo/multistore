package com.anizmocreations.multistore.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreResponse {

  private int storeId;

  private String storeName;

  private String storeDescription;

  private String storeUsername;

  private String phoneNumber;

}
