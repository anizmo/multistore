package com.anizmocreations.multistore.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

  private int productId;

  private int userId;

  private int quantity;

}
