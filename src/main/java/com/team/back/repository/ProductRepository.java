package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
  ProductEntity findByProductCode(Integer ProductCode);
}
