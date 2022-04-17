package com.anizmocreations.multistore.repository;

import com.anizmocreations.multistore.tables.Product;
import com.anizmocreations.multistore.tables.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {
}