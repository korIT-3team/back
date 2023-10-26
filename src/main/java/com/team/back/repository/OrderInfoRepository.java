package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.OrderInfoEntity;
import com.team.back.entity.resultSets.OrderInfoListResultSet;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, Integer> {

  @Query(
    value=
      "SELECT ROW_NUMBER() OVER(ORDER BY order_code) AS no, " +
      "order_code AS orderCode, " +
      "sales_plan_code AS salesPlanCode, " +
      "company_code AS companyCode, " +
      "customer_code AS customerCode, " +
      "order_date AS orderDate, " +
      "manager_code AS managerCode, " +
      "order_detail AS orderDetail, " +
      "order_price AS orderPrice " +
      "FROM order_information " +
      "ORDER BY order_code ",
      nativeQuery=true
  )
  List<OrderInfoListResultSet> getOrderInfoList(Integer OrderCode);
  
}
