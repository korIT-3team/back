package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SalesPlanEntity;

@Repository
public interface SalesPlanRepository extends JpaRepository<SalesPlanEntity, Integer> {
  
  SalesPlanEntity findBySalesPlanCode(Integer salesPlanCode);

  @Query(
    value=
      "SELECT * " +
      "FROM sales_plan ",
      nativeQuery=true
  )
  List<SalesPlanEntity> getSalesPlanList(String departmentCode, String employeeCode, String planDate, String productCode, String productName, String planQuantity, String exchangeType, String exchangeRate, String expectPrice, String expectTotalPrice);
}
