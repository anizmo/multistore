package com.anizmocreations.multistore.tables;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
public class Store {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int storeId;

  private String storeName;

  private String storeDescription;

  @Column(unique = true)
  private String storeUsername;

  @Column(unique = true)
  private String phoneNumber;

  private String password;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
  private Set<Product> products;

}


