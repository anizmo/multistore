package com.anizmocreations.multistore.service;

import com.anizmocreations.multistore.repository.StoresRepo;
import com.anizmocreations.multistore.requests.ProductRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.tables.Product;
import com.anizmocreations.multistore.repository.ProductsRepo;
import com.anizmocreations.multistore.utils.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.anizmocreations.multistore.utils.Utility.convertProductToProductResponse;

@ComponentScan(basePackages = "com.anizmocreations")
@Service
public class ProductsService {

  @Autowired
  ProductsRepo productsRepo;

  @Autowired
  StoresRepo storesRepo;

  public ProductResponse getProductByProductId(int productId) {
    final List<Product> products = new ArrayList<>();
    productsRepo.findById(productId).ifPresent(products::add);

    if (products.size() > 0) {
      Product product = products.get(0);
      return convertProductToProductResponse(product);
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product ID does not exist");
  }

  public ProductResponse addProductToDB(ProductRequest productRequest) {
    Product product = new Product();
    product.setProductName(productRequest.getProductName());
    product.setCostPrice(productRequest.getCostPrice());
    product.setStore(storesRepo.findByStoreId(productRequest.getStoreId()));
    return convertProductToProductResponse(productsRepo.save(product));

  }

}
