package com.edex.commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.commerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    
} 