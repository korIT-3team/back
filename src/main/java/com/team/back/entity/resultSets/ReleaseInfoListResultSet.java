package com.team.back.entity.resultSets;

public interface ReleaseInfoListResultSet {
  int getNo();
  int getReleaseCodeInfo();
  String getReleaseDate();
  int getCustomerCodeInfo();
  int getProductCode();
  String getProductName();
  int getOrderQuantity();
  double getProductPrice();
  double getSupplyPrice();
  double getSurtax();
  double getTotalPrice();
}
