package com.team.back.entity.resultSets;

public interface SalesPlanListResultSet {
  int getNo();
  int getSalesPlanCode();
  String getProjectName();
  String getPlanDate();
  int getProductCode();
  String getProductName();
  int getPlanQuantity();
  double getExpectPrice();
  double getExpectTotalPrice();
  int getEmployeeCode();
  String getEmployeeName();
}
