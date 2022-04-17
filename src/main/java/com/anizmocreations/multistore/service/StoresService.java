package com.anizmocreations.multistore.service;

import com.anizmocreations.multistore.repository.StoresRepo;
import com.anizmocreations.multistore.requests.StoreRequest;
import com.anizmocreations.multistore.responses.ProductResponse;
import com.anizmocreations.multistore.responses.StoreResponse;
import com.anizmocreations.multistore.tables.Store;
import com.anizmocreations.multistore.utils.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ComponentScan(basePackages = "com.anizmocreations")
@Service
public class StoresService {

  @Autowired
  StoresRepo storesRepo;

  public StoreResponse getStore(int id) {
    if (id < 0) {
      throw new IllegalArgumentException("Store ID cannot be a negative integer.");
    }

    Store store = storesRepo.findByStoreId(id);

    if (store != null) {
      return Utility.convertStoreToStoreResponse(store);
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Store ID does not exist");
  }

  public void registerStore(StoreRequest request) {
    if (request == null) {
      throw new IllegalArgumentException("Store Request Cannot be null");
    }

    if (request.getStoreName() == null || request.getStoreName().isEmpty()) {
      throw new IllegalArgumentException("Store Name is Required");
    }

    if (request.getStoreDescription() == null || request.getStoreDescription().isEmpty()) {
      throw new IllegalArgumentException("Store Description is Required");
    }

    if (request.getStoreUsername() == null || request.getStoreUsername().isEmpty()) {
      throw new IllegalArgumentException("Store Username is Required");
    }

    if (request.getPassword() == null || request.getPassword().isEmpty()) {
      throw new IllegalArgumentException("Password is Required");
    }

    Store store = new Store();
    store.setStoreName(request.getStoreName());
    store.setStoreDescription(request.getStoreDescription());
    store.setStoreUsername(request.getStoreUsername());
    store.setPassword(request.getPassword());
    store.setPhoneNumber(request.getStorePhoneNumber());
    storesRepo.save(store);
  }

  public List<ProductResponse> getAllProducts(int storeId) {
    return storesRepo.findByStoreId(storeId).getProducts().stream()
            .map(Utility::convertProductToProductResponse)
            .sorted(Comparator.comparingInt(ProductResponse::getProductId))
            .collect(Collectors.toList());
  }

}
