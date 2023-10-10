package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.CustomerEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
  boolean existsByCustomerCode(Integer customerCode);
  boolean existsByCustomerName(String customerName);
  boolean existsByCustomerBusinessNumber(String businessNumber);
  
  CustomerEntity findByCustomerCode(Integer CustomerCode);

  @Query(
    value = 
    "SELECT ROW_NUMBER() OVER(ORDER BY customer_code) AS no, " +
    "customer_code AS customerCode, " +
    "company_code AS companyCode, " +
    "customer_name AS customerName, " +
    "business_Number AS customerBusinessNumber, " +
    "customer_post_code AS customerPostCode, " +
    "customer_address AS customerAddress, " +
    "customer_address_detail AS customerAddressDetail, " +
    "customer_tel_number AS customerTelNumber " +
    "FROM customer " +
    "ORDER BY customer_code ",

    nativeQuery=true
  )
  List<CustomerListResultSet> getCustomerList(Integer customerCode);
}
