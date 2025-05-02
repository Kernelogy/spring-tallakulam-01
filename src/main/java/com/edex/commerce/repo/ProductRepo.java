package com.edex.commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.commerce.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
