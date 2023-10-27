package com.team.back.entity.resultSets;

public interface SalesPlanListResultSet {
  int getNo();
  int getSalesPlanCode();
  String getProjectName();
  int getDepartmentCode();
  String getDepartmentName();
  int getEmployeeCode();
  String getEmployeeName();
  int getCompanyCode();
  String getPlanDate();
  int getProductCode();
  String getProductName();
  String getSalesPlanUnit();
  int getPlanQuantity();
  int getExchangeRateCode();
  double getExchangeRate();
  double getExpectPrice();
  double getExpectTotalPrice();
  double getExpectKoreanPrice();
}
