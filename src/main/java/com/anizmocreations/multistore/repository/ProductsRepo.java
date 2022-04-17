package com.anizmocreations.multistore.repository;

import com.anizmocreations.multistore.tables.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {
}