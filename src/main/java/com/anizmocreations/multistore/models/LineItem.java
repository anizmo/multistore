package com.anizmocreations.multistore.models;

import com.anizmocreations.multistore.tables.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {

  private Product product;

  private int quantity;

}
