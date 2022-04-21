package com.anizmocreations.multistore.controller;

import com.anizmocreations.multistore.requests.StoreRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.responses.StoreResponse;
import com.anizmocreations.multistore.service.StoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan(basePackages = "com.anizmocreations")
@Component
@RestController
@RequestMapping(path = "/stores")
public class StoresController {

  @Autowired
  private StoresService storesService;

  @GetMapping(params = {"id"})
  @ResponseStatus(HttpStatus.OK)
  public StoreResponse getStoreByStoreId(@RequestParam("id") int storeId) {
    return storesService.getStore(storeId);
  }

  @PostMapping(value = "/register")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> registerStore(@RequestBody StoreRequest request) {
    storesService.registerStore(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "/products", params = {"storeId"})
  public List<ProductResponse> getProductByStoreId(@RequestParam("storeId") int storeId) {
    return storesService.getAllProducts(storeId);
  }

}
