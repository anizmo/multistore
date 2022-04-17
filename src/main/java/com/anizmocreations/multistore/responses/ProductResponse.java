package com.anizmocreations.multistore.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {

  private int productId;

  private String productName;

  private double costPrice;

}
