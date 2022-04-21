package com.anizmocreations.multistore.tables;

import com.anizmocreations.multistore.models.LineItem;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cartId;

  private List<LineItem> lineItems;

  @OneToOne(fetch = FetchType.LAZY)
  private User userId;

  @OneToOne(fetch = FetchType.LAZY)
  private Store storeId;

  public double getTotalAmount() {
    double totalAmount = 0;

    for (LineItem item : lineItems) {
      totalAmount += (item.getProduct().getCostPrice() * item.getQuantity());
    }

    return totalAmount;
  }

}
