package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.CustomerEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

  boolean existsByCustomerCode(Integer customerCode);

  CustomerEntity findByCustomerCode(Integer customerCode);
  
  List<CustomerListResultSet> getCustomerList();
}
