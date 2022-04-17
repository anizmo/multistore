package com.anizmocreations.multistore.repository;

import com.anizmocreations.multistore.tables.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepo extends JpaRepository<Store, Integer> {

  Store findByStoreUsername(String storeUsername);

  Store findByStoreId(int storeId);

}
