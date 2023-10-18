package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.back.entity.ProductEntity;
import com.team.back.entity.resultSets.ProductListResultSet;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
  
@Query(
  value = 
    "SELECT ROW_NUMBER() OVER(ORDER BY customer_code) AS no, " +
    "product_code AS productCode, " +
    "procurement_category AS procurementCategory, " +
    "product_name AS productName, " +
    "company_code AS companyCode, " +
    "product_price AS productPrice " +
    "FROM product " +
    "ORDER BY product_code ",

    nativeQuery=true
)

  List<ProductListResultSet> getProductList(String productName, int procurementCategory);
}
