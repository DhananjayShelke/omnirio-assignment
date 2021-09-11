package com.assignment.omnirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.omnirio.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{

}
