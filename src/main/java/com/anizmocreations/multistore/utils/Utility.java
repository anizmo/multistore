package com.anizmocreations.multistore.utils;

import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.responses.StoreResponse;
import com.anizmocreations.multistore.tables.Product;
import com.anizmocreations.multistore.tables.Store;

public class Utility {

  /**
   * Converts a Store Object to StoreResponse Object that is a skimmed down version of the Store,
   * this is done in order to get rid of nested objects of Products and Stores.
   *
   * @param store the store object which is to be converted.
   * @return      storeResponse object corresponding to the store object.
   */
  public static StoreResponse convertStoreToStoreResponse(Store store) {
    return new StoreResponse(store.getStoreId(), store.getStoreName(), store.getStoreDescription(),
            store.getStoreUsername(), store.getPhoneNumber());
  }

  /**
   *
   *
   * @param product
   * @return
   */
  public static ProductResponse convertProductToProductResponse(Product product) {
    return new ProductResponse(product.getProductId(),
            product.getProductName(), product.getCostPrice());
  }

}
