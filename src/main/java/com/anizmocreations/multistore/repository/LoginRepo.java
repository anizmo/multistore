package com.anizmocreations.multistore.repository;

import com.anizmocreations.multistore.tables.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<User, Integer> {

  User findByUsername(String username);

  User findByEmail(String email);

  User findByPhoneNumber(String phoneNumber);

}
