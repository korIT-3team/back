package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SalesPlanEntity;
import com.team.back.entity.resultSets.SalesPlanListResultSet;

@Repository
public interface SalesPlanRepository extends JpaRepository<SalesPlanEntity, Integer> {
  
  boolean existsByProjectName(String projectName);

  SalesPlanEntity findBySalesPlanCode(Integer salesPlanCode);

  @Query(
    value=
      "SELECT ROW_NUMBER() OVER(ORDER BY sales_plan_code) AS no, " +
      "sales_plan_code AS salesPlanCode, " +
      "project_name AS projectName, " +
      "department_code AS departmentCode, " +
      "employee_code AS employeeCode, " +
      "company_code AS companyCode, " +
      "plan_date AS plan_date, " +
      "product_code AS productCode, " +
      "plan_quantity AS planQuantity, " +
      "exchange_rate_code AS exchangeRateCode, " +
      "exchange_rate AS exchangeRate, " +
      "expect_price AS expectPrice, " +
      "expect_total_price AS expectTotalPrice, " +
      "expect_korean_price AS expectKoreanPrice " +
      "FROM sales_plan as SP" +
      "ORDER BY sales_plan_code ",
      nativeQuery=true
  )
  List<SalesPlanListResultSet> getSalesPlanList(Integer salesPlanCode);
}
