package com.edex.commerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.commerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);
    List<User> findByFirstName(String firstName);
    
} 