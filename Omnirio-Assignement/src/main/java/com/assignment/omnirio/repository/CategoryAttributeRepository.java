package com.assignment.omnirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.omnirio.entity.CategoryAttribute;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Long>{

}
