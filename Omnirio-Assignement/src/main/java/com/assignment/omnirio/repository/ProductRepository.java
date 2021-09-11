package com.assignment.omnirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.omnirio.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
