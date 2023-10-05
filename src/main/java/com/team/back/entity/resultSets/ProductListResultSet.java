package com.team.back.entity.resultSets;

public interface ProductListResultSet {
  int getCompanyCode();
  int getProductCode();
  String getProductName();
  int getProcurementCategory();
  double getProductPrice();
}
