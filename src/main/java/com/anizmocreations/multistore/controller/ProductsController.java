package com.anizmocreations.multistore.controller;

import com.anizmocreations.multistore.requests.ProductRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.tables.Product;
import com.anizmocreations.multistore.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan(basePackages = "com.anizmocreations")
@Component
@RestController
@RequestMapping(path = "/products")
public class ProductsController {

  @Autowired
  ProductsService productsService;

  @RequestMapping(params = {"id"}, method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse getProductByProductId(@RequestParam("id") int productId) {
    return productsService.getProductByProductId(productId);
  }

  @PostMapping(value = "/add")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
    return productsService.addProductToDB(productRequest);
  }

}