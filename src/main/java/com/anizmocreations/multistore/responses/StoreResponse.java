package com.anizmocreations.multistore.responses;

import com.anizmocreations.multistore.tables.Product;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
