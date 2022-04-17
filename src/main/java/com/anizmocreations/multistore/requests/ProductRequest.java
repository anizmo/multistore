package com.anizmocreations.multistore.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

  private String productName;

  private double costPrice;

  private int storeId;

}
