package com.anizmocreations.multistore.controller;

import com.anizmocreations.multistore.requests.ProductRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.service.CartService;
import com.anizmocreations.multistore.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "com.anizmocreations")
@Component
@RestController
@RequestMapping(path = "/cart")
public class ShoppingCartController {

  @Autowired
  private CartService cartService;

  @PostMapping(value = "/add")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse addToCart(@RequestBody ProductRequest productRequest) {
    return cartService.addToCart(productRequest);
  }

}