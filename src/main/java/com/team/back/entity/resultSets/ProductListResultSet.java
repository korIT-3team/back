package com.team.back.entity.resultSets;

public interface ProductListResultSet {
  int getNo();
  int getCompanyCode();
  int getProductCode();
  String getProductName();
  String getProcurementCategory();
  double getProductPrice();
}
