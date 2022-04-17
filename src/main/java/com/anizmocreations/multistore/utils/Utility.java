package com.anizmocreations.multistore.utils;

import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.responses.StoreResponse;
import com.anizmocreations.multistore.tables.Product;
import com.anizmocreations.multistore.tables.Store;

import java.util.stream.Collectors;

public class Utility {

  public static StoreResponse convertStoreToStoreResponse(Store store) {
    return new StoreResponse(store.getStoreId(), store.getStoreName(), store.getStoreDescription(),
            store.getStoreUsername(), store.getPhoneNumber());
  }

  public static ProductResponse convertProductToProductResponse(Product product) {
    return new ProductResponse(product.getProductId(),
            product.getProductName(), product.getCostPrice());
  }

}
