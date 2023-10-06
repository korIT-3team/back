package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
  CustomerEntity findByCustomerCode(Integer CustomerCode);
}
