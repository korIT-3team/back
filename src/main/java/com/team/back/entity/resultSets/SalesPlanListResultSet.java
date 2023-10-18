package com.team.back.entity.resultSets;

public interface SalesPlanListResultSet {
  int getNo();
  int getSalesPlanCode();
  String getProjectName();
  int getEmployeeCode();
  int getDepartmentCode();
  int getCompanyCode();
  String getPlanDate();
  int getProductCode();
  int getPlanQuantity();
  int getExchangeRateCode();
  double getExchangeRate();
  double getExpectPrice();
  double getExpectTotalPrice();
  double getExpectKoreanPrice();
}
