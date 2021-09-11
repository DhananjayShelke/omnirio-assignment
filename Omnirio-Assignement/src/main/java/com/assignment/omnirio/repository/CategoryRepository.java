package com.assignment.omnirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.omnirio.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
