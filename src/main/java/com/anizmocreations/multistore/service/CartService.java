package com.anizmocreations.multistore.service;

import com.anizmocreations.multistore.repository.ProductsRepo;
import com.anizmocreations.multistore.repository.StoresRepo;
import com.anizmocreations.multistore.requests.ProductRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.tables.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static com.anizmocreations.multistore.utils.Utility.convertProductToProductResponse;

@ComponentScan(basePackages = "com.anizmocreations")
@Service
public class CartService {

  @Autowired
  private ProductsRepo productsRepo;

  @Autowired
  private StoresRepo storesRepo;

  /**
   * Insert a product into the Product Table with the specified parameters in the productRequest.
   * The store in which the product is to be inserted is specified in the productRequest and the
   * association between the store and product is handled by the setStore.
   *
   * @param productRequest  Specification of the product to be inserted.
   * @return                Product Response
   */
  public ProductResponse addToCart(ProductRequest productRequest) {
    Product product = new Product();
    product.setProductName(productRequest.getProductName());
    product.setCostPrice(productRequest.getCostPrice());
    product.setStore(storesRepo.findByStoreId(productRequest.getStoreId()));
    return convertProductToProductResponse(productsRepo.save(product));
  }

}
