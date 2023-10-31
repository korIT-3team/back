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
      "plan_date AS planDate, " +
      "product_code AS productCode, " +
      "product_name AS productName, " +
      "plan_quantity AS planQuantity, " +
      "expect_price AS expectPrice, " +
      "expect_total_price AS expectTotalPrice, " +
      "employee_code AS employeeCode, " +
      "E.employee_name AS employeeName " +
      "FROM sales_plan as SP" +
      "LEFT OUTER JOIN product AS P ON P.product_code = SP.product_code " +
      "LEFT OUTER JOIN product AS P ON P.product_name = SP.product_name " +
      "LEFT OUTER JOIN employee AS E ON E.employee_code = SP.employee_code " +
      "WHERE E.employee_code != 0 " +
      "AND project_name LIKE %?1% " +
      "ORDER BY sales_plan_code ",
      nativeQuery=true
  )
  List<SalesPlanListResultSet> getSalesPlanList(String projectName);
}
